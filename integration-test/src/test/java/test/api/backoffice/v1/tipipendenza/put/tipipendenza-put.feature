Feature: Censimento tipiPendenza

Background:

* callonce read('classpath:utils/common-utils.feature')
* callonce read('classpath:configurazione/v1/anagrafica.feature')
* def basicAutenticationHeader = getBasicAuthenticationHeader( { username: govpay_backoffice_user, password: govpay_backoffice_password } )
* def backofficeBaseurl = getGovPayApiBaseUrl({api: 'backoffice', versione: 'v1', autenticazione: 'basic'})
* def tipoPendenza = 
"""
{
  descrizione: "Sanzione codice della strada",
  tipo: "dovuto",
  codificaIUV: "030",
  pagaTerzi: true,
  form: { 
  	tipo: "angular2-json-schema-form",
  	definizione: null
  },
  trasformazione: {
  	tipo: "freemarker",
  	definizione: null
  },
  validazione: null,
  visualizzazione: null,
  tracciatoCsv: {
  	tipo: "freemarker",
  	intestazione: "idA2A,idPendenza,idDominio",
  	richiesta: null,
	  risposta: null
  }
}
"""          
* set tipoPendenza.form.definizione = encodeBase64InputStream(read('msg/tipoPendenza-dovuta-form.json.payload'))
* set tipoPendenza.trasformazione.definizione = encodeBase64InputStream(read('msg/tipoPendenza-dovuta-freemarker.ftl'))
* set tipoPendenza.validazione = encodeBase64InputStream(read('msg/tipoPendenza-dovuta-validazione-form.json'))
* set tipoPendenza.visualizzazione = encodeBase64InputStream(read('msg/tipoPendenza-dovuta-visualizzazione.json.payload'))
* set tipoPendenza.tracciatoCsv.richiesta = encodeBase64InputStream(read('msg/tracciato-csv-freemarker-request.ftl'))
* set tipoPendenza.tracciatoCsv.risposta = encodeBase64InputStream(read('msg/tracciato-csv-freemarker-response.ftl'))

Scenario: Aggiunta di un tipoPendenza

Given url backofficeBaseurl
And path 'tipiPendenza', 'SCDS'
And headers basicAutenticationHeader
And request tipoPendenza
When method put
Then assert responseStatus == 200 || responseStatus == 201

Scenario Outline: Modifica di una tipoPendenza (<field>)

* set tipoPendenza.<field> = <value>

Given url backofficeBaseurl
And path 'tipiPendenza', 'SCDS'
And headers basicAutenticationHeader
And request tipoPendenza
When method put
Then assert responseStatus == 200 || responseStatus == 201

Given url backofficeBaseurl
And path 'tipiPendenza', 'SCDS'
And headers basicAutenticationHeader
When method get
Then status 200
And match response.<field> == <checkValue>

Examples:
| field | value | checkValue |
| descrizione | 'Nuova descrizione' | 'Nuova descrizione' |
| tipo | 'spontaneo' | 'spontaneo' |
| tipo | 'dovuto' | 'dovuto' |
| codificaIUV | null | '#notpresent' |
| codificaIUV | '090' | '090' |
| pagaTerzi | true | true |
| pagaTerzi | false | false |
| validazione | { "tipo": "angular2-json-schema-form", "definizione": "eyAidHlwZSI6ICJvYmplY3QiIH0=" } | { "tipo": "angular2-json-schema-form", "definizione": "eyAidHlwZSI6ICJvYmplY3QiIH0=" } |
| validazione | null | '#notpresent' |
| trasformazione | { "tipo": "freemarker", "definizione": "eyAidHlwZSI6ICJvYmplY3QiIH0=" } | { "tipo": "freemarker", "definizione": "eyAidHlwZSI6ICJvYmplY3QiIH0=" } |
| trasformazione | null | '#notpresent' |
| inoltro | idA2A | idA2A |
| inoltro | null | '#notpresent' |
| promemoriaAvviso | { "abilitato": true, "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": true } | { "abilitato": true, "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": true } |
| promemoriaAvviso | { "abilitato": false,  "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": false } | { "abilitato": false,  "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": false } |
| promemoriaAvviso | { "abilitato": false, "tipo": null, "oggetto": null, "messaggio": null, "allegaPdf" : null } | { "abilitato": false, "tipo": '#notpresent', "oggetto": '#notpresent', "messaggio": '#notpresent', "allegaPdf" : '#notpresent' } |
| promemoriaAvviso | { "abilitato": true, "tipo": null, "oggetto": null, "messaggio": null, "allegaPdf" : null } | { "abilitato": true, "tipo": '#notpresent', "oggetto": '#notpresent', "messaggio": '#notpresent', "allegaPdf" : '#notpresent' } |
| promemoriaAvviso | { "abilitato": true, "tipo": "freemarker", "oggetto": "aaa", "messaggio": null, "allegaPdf" : null } | { "abilitato": true, "tipo": "freemarker", "oggetto": "aaa", "messaggio": '#notpresent', "allegaPdf" : '#notpresent' } |
| promemoriaAvviso | { "abilitato": true, "tipo": "freemarker", "oggetto": null, "messaggio": "aaa", "allegaPdf" : null } | { "abilitato": true, "tipo": "freemarker", "oggetto": '#notpresent', "messaggio": "aaa", "allegaPdf" : '#notpresent' } |
| promemoriaAvviso | { "abilitato": true, "tipo": "freemarker", "oggetto": null, "messaggio": "aaa", "allegaPdf" : true } | { "abilitato": true, "tipo": "freemarker", "oggetto": '#notpresent', "messaggio": "aaa", "allegaPdf" : true } |
| promemoriaRicevuta | { "abilitato": true, "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": true } | { "abilitato": true, "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": true } |
| promemoriaRicevuta | { "abilitato": false,  "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": false } | { "abilitato": false,  "tipo": "freemarker", "oggetto": "Promemoria pagamento", "messaggio": "Devi pagare", "allegaPdf": false } |
| promemoriaRicevuta | { "abilitato": false, "tipo": null, "oggetto": null, "messaggio": null, "allegaPdf" : null } | { "abilitato": false, "tipo": '#notpresent', "oggetto": '#notpresent', "messaggio": '#notpresent', "allegaPdf" : '#notpresent' } |
| promemoriaRicevuta | { "abilitato": true, "tipo": null, "oggetto": null, "messaggio": null, "allegaPdf" : null } | { "abilitato": true, "tipo": '#notpresent', "oggetto": '#notpresent', "messaggio": '#notpresent', "allegaPdf" : '#notpresent' } |
| promemoriaRicevuta | { "abilitato": true, "tipo": "freemarker", "oggetto": "aaa", "messaggio": null, "allegaPdf" : null } | { "abilitato": true, "tipo": "freemarker", "oggetto": "aaa", "messaggio": '#notpresent', "allegaPdf" : '#notpresent' } |
| promemoriaRicevuta | { "abilitato": true, "tipo": "freemarker", "oggetto": null, "messaggio": "aaa", "allegaPdf" : null } | { "abilitato": true, "tipo": "freemarker", "oggetto": '#notpresent', "messaggio": "aaa", "allegaPdf" : '#notpresent' } |
| promemoriaRicevuta | { "abilitato": true, "tipo": "freemarker", "oggetto": null, "messaggio": "aaa", "allegaPdf" : true } | { "abilitato": true, "tipo": "freemarker", "oggetto": '#notpresent', "messaggio": "aaa", "allegaPdf" : true } |
| visualizzazione | null | '#notpresent' |
| tracciatoCsv | null | '#notpresent'	 |


Scenario: Configurazione di due tipiPendenza con idTipoPendenza del secondo che e' una sottostringa del primo idTipoPendenza	 

* def idComune = getCurrentTimeMillis()
* def idTipoPendenza1 = 'PROVA_' + idComune
* def idTipoPendenza2 = 'OVA_' + idComune


Given url backofficeBaseurl
And path 'tipiPendenza', idTipoPendenza1
And headers basicAutenticationHeader
And request tipoPendenza
When method put
Then assert responseStatus == 200 || responseStatus == 201

Given url backofficeBaseurl
And path 'tipiPendenza', idTipoPendenza2
And headers basicAutenticationHeader
And request tipoPendenza
When method put
Then assert responseStatus == 200 || responseStatus == 201





