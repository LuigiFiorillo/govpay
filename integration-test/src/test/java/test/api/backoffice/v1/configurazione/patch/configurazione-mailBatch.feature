Feature: Validazione sintattica domini

Background:

* callonce read('classpath:utils/common-utils.feature')
* callonce read('classpath:configurazione/v1/anagrafica.feature')
* def basicAutenticationHeader = getBasicAuthenticationHeader( { username: govpay_backoffice_user, password: govpay_backoffice_password } )
* def backofficeBaseurl = getGovPayApiBaseUrl({api: 'backoffice', versione: 'v1', autenticazione: 'basic'})
* def loremIpsum = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus non neque vestibulum, porta eros quis, fringilla enim. Nam sit amet justo sagittis, pretium urna et, convallis nisl. Proin fringilla consequat ex quis pharetra. Nam laoreet dignissim leo. Ut pulvinar odio et egestas placerat. Quisque tincidunt egestas orci, feugiat lobortis nisi tempor id. Donec aliquet sed massa at congue. Sed dictum, elit id molestie ornare, nibh augue facilisis ex, in molestie metus enim finibus arcu. Donec non elit dictum, dignissim dui sed, facilisis enim. Suspendisse nec cursus nisi. Ut turpis justo, fermentum vitae odio et, hendrerit sodales tortor. Aliquam varius facilisis nulla vitae hendrerit. In cursus et lacus vel consectetur.'
* def string71 = '1GLqJdabGYFpRi4RbM8gWlnpCzVvMyeKC2qoCYkqfvTyGZ1eovAxsFqpGfVqzzXXjCfMsKi'
* def string17 = 'LS2wIWYPN0QPsgTbX'
* def string36 = 'VTnniDMiQ2ngyoDMBnfzeGUPKTbhx2U7fMO1'
* def patch = 
"""
[
  {
    "op": "REPLACE",
    "path": "/mailBatch",
    "value": {
			"abilitato": true,
			"mailserver": {
				"host": "smtp.entecreditore.it",
				"port": "25",
				"username": "usrpagopa",
				"password": "changeme",
				"from": "pagopa@entecreditore.it",
				"readTimeout": 120000,
				"connectTimeout": 10000
			}
		}
  }
]
"""

Scenario Outline: Modifica della configurazione batch (<field>)


* set patch.value.<field> = <value>
* def checkValue = <value> != null ? <value> : '#notpresent'

Given url backofficeBaseurl
And path 'configurazioni'
And headers basicAutenticationHeader
And request batch
When method patch
Then assert responseStatus == 200

Given url backofficeBaseurl
And path 'configurazioni'
And headers basicAutenticationHeader
When method get
Then status 200
And match response.mailBatch.<field> == checkValue

Examples:
| field | value | 
| abilitato | true |
| abilitato | false |
| mailserver.host | "smtp.myhost.it" |
| mailserver.port | 10 |
| mailserver.username | "xxxx" |
| mailserver.password | "xxxx" |
| mailserver.from | "from@xxx.org" |
| mailserver.readTimeout | 0 |
| mailserver.connectTimeout | 0 |
