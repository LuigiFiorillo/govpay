-- 29/08/2019 Autorizzazione utenze per UO
ALTER TABLE utenze_domini ADD COLUMN id_uo NUMBER;
ALTER TABLE utenze_domini ADD CONSTRAINT fk_nzd_id_uo FOREIGN KEY (id_uo) REFERENCES uo(id);
ALTER TABLE utenze_domini MODIFY (id_dominio NULL);

-- 26/09/2019 Identificativo univoco di creazione del versamento
ALTER TABLE versamenti ADD COLUMN id_sessione VARCHAR2(35 CHAR);

DROP VIEW versamenti_incassi;

CREATE VIEW versamenti_incassi AS
SELECT
versamenti.id as id,
MAX(versamenti.cod_versamento_ente) as cod_versamento_ente,
MAX(versamenti.nome) as nome,
MAX(versamenti.importo_totale) as importo_totale,
versamenti.stato_versamento as stato_versamento,
MAX(versamenti.descrizione_stato) as descrizione_stato,
MAX(CASE WHEN versamenti.aggiornabile = 1 THEN 'TRUE' ELSE 'FALSE' END) AS aggiornabile,
MAX(versamenti.data_creazione) as data_creazione,
MAX(versamenti.data_validita) as data_validita,
MAX(versamenti.data_scadenza) as data_scadenza,
MAX(versamenti.data_ora_ultimo_aggiornamento) as data_ora_ultimo_aggiornamento,
MAX(versamenti.causale_versamento) as causale_versamento,
MAX(versamenti.debitore_tipo) as debitore_tipo,
versamenti.debitore_identificativo as debitore_identificativo,
MAX(versamenti.debitore_anagrafica) as debitore_anagrafica,
MAX(versamenti.debitore_indirizzo) as debitore_indirizzo,
MAX(versamenti.debitore_civico) as debitore_civico,
MAX(versamenti.debitore_cap) as debitore_cap,
MAX(versamenti.debitore_localita) as debitore_localita,
MAX(versamenti.debitore_provincia) as debitore_provincia,
MAX(versamenti.debitore_nazione) as debitore_nazione,
MAX(versamenti.debitore_email) as debitore_email,
MAX(versamenti.debitore_telefono) as debitore_telefono,
MAX(versamenti.debitore_cellulare) as debitore_cellulare,
MAX(versamenti.debitore_fax) as debitore_fax,
MAX(versamenti.tassonomia_avviso) as tassonomia_avviso,
MAX(versamenti.tassonomia) as tassonomia,
MAX(versamenti.cod_lotto) as cod_lotto,
MAX(versamenti.cod_versamento_lotto) as cod_versamento_lotto,
MAX(versamenti.cod_anno_tributario) as cod_anno_tributario,
MAX(versamenti.cod_bundlekey) as cod_bundlekey,
MAX(dbms_lob.substr(versamenti.dati_allegati)) as dati_allegati,
MAX(versamenti.incasso) as incasso,
MAX(dbms_lob.substr(versamenti.anomalie)) as anomalie,
MAX(versamenti.iuv_versamento) as iuv_versamento,
MAX(versamenti.numero_avviso) as numero_avviso,
MAX(versamenti.id_dominio) as id_dominio,
MAX(versamenti.id_tipo_versamento) AS id_tipo_versamento,
MAX(versamenti.id_tipo_versamento_dominio) AS id_tipo_versamento_dominio,
MAX(versamenti.id_uo) as id_uo,
MAX(versamenti.id_applicazione) as id_applicazione,
MAX(CASE WHEN versamenti.avvisatura_abilitata = 1 THEN 'TRUE' ELSE 'FALSE' END) AS avvisatura_abilitata,
MAX(CASE WHEN versamenti.avvisatura_da_inviare = 1 THEN 'TRUE' ELSE 'FALSE' END) AS avvisatura_da_inviare,
MAX(versamenti.avvisatura_operazione) as avvisatura_operazione,               
MAX(versamenti.avvisatura_modalita) as avvisatura_modalita,
MAX(versamenti.avvisatura_tipo_pagamento) as avvisatura_tipo_pagamento,                   
MAX(versamenti.avvisatura_cod_avvisatura) as avvisatura_cod_avvisatura,  
MAX(versamenti.divisione) as divisione,  
MAX(versamenti.direzione) as direzione,     
MAX(versamenti.id_tracciato) as id_tracciato,
MAX(versamenti.id_sessione) as id_sessione,
MAX(CASE WHEN versamenti.ack = 1 THEN 'TRUE' ELSE 'FALSE' END) AS ack,
MAX(CASE WHEN versamenti.anomalo = 1 THEN 'TRUE' ELSE 'FALSE' END) AS anomalo,
MAX(pagamenti.data_pagamento) as data_pagamento,
SUM(CASE WHEN pagamenti.importo_pagato IS NOT NULL THEN pagamenti.importo_pagato ELSE 0 END) AS importo_pagato,
SUM(CASE WHEN pagamenti.stato = 'INCASSATO' THEN pagamenti.importo_pagato ELSE 0 END) AS importo_incassato,
MAX(CASE WHEN pagamenti.stato IS NULL THEN 'NON_PAGATO' WHEN pagamenti.stato = 'INCASSATO' THEN 'INCASSATO' ELSE 'PAGATO' END) AS stato_pagamento,
MAX(pagamenti.iuv) AS iuv_pagamento,
MAX(CASE WHEN versamenti.stato_versamento = 'NON_ESEGUITO' AND versamenti.data_validita > CURRENT_DATE THEN 0 ELSE 1 END) AS smart_order_rank,
MIN(ABS((date_to_unix_for_smart_order(CURRENT_DATE) * 1000) - (date_to_unix_for_smart_order(COALESCE(pagamenti.data_pagamento, versamenti.data_validita, versamenti.data_creazione))) *1000)) AS smart_order_date
FROM versamenti LEFT JOIN singoli_versamenti ON versamenti.id = singoli_versamenti.id_versamento LEFT join pagamenti on singoli_versamenti.id = pagamenti.id_singolo_versamento 
JOIN tipi_versamento ON tipi_versamento.id = versamenti.id_tipo_versamento 
GROUP BY versamenti.id, versamenti.debitore_identificativo, versamenti.stato_versamento;


-- 01/10/2019 Configurazione Regole di Hardening API Public
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.hardening.enabled','true');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.serverURL','https://www.google.com/recaptcha/api/siteverify');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.siteKey','CHANGE_ME');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.secretKey','CHANGE_ME');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.soglia','1.0');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.responseParameter','gRecaptchaResponse');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.denyOnFail','true');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.readTimeout','5000');
INSERT INTO configurazione (NOME,VALORE) values ('it.govpay.autorizzazione.utenzaAnonima.googleCaptcha.connectionTimeout','5000');




