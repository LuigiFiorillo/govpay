-- Gli indici vengono eliminati automaticamente una volta eliminata la tabella
-- DROP INDEX index_iuv_1 CASCADE CASCADE;
DROP TRIGGER trg_rendicontazioni CASCADE CASCADE;
DROP TRIGGER trg_eventi CASCADE CASCADE;
DROP TRIGGER trg_pagamenti CASCADE CASCADE;
DROP TRIGGER trg_fr CASCADE CASCADE;
DROP TRIGGER trg_iuv CASCADE CASCADE;
DROP TRIGGER trg_notifiche CASCADE CASCADE;
DROP TRIGGER trg_rr CASCADE CASCADE;
DROP TRIGGER trg_rpt CASCADE CASCADE;
DROP TRIGGER trg_singoli_versamenti CASCADE CASCADE;
DROP TRIGGER trg_versamenti CASCADE CASCADE;
DROP TRIGGER trg_acl CASCADE CASCADE;
DROP TRIGGER trg_tributi CASCADE CASCADE;
DROP TRIGGER trg_tipi_tributo CASCADE CASCADE;
DROP TRIGGER trg_iban_accredito CASCADE CASCADE;
DROP TRIGGER trg_portali CASCADE CASCADE;
DROP TRIGGER trg_connettori CASCADE CASCADE;
DROP TRIGGER trg_operatori CASCADE CASCADE;
DROP TRIGGER trg_uo CASCADE CASCADE;
DROP TRIGGER trg_domini CASCADE CASCADE;
DROP TRIGGER trg_applicazioni CASCADE CASCADE;
DROP TRIGGER trg_stazioni CASCADE CASCADE;
DROP TRIGGER trg_intermediari CASCADE CASCADE;
DROP TRIGGER trg_canali CASCADE CASCADE;
DROP TRIGGER trg_psp CASCADE CASCADE;
DROP TABLE ID_MESSAGGIO_RELATIVO CASCADE CASCADE;
DROP TABLE rendicontazioni CASCADE CASCADE;
DROP TABLE eventi CASCADE CASCADE;
DROP TABLE pagamenti CASCADE CASCADE;
DROP TABLE fr CASCADE CASCADE;
DROP TABLE iuv CASCADE CASCADE;
DROP TABLE notifiche CASCADE CASCADE;
DROP TABLE rr CASCADE CASCADE;
DROP TABLE rpt CASCADE CASCADE;
DROP TABLE singoli_versamenti CASCADE CASCADE;
DROP TABLE versamenti CASCADE CASCADE;
DROP TABLE acl CASCADE CASCADE;
DROP TABLE tributi CASCADE CASCADE;
DROP TABLE tipi_tributo CASCADE CASCADE;
DROP TABLE iban_accredito CASCADE CASCADE;
DROP TABLE portali CASCADE CASCADE;
DROP TABLE connettori CASCADE CASCADE;
DROP TABLE operatori CASCADE CASCADE;
DROP TABLE uo CASCADE CASCADE;
DROP TABLE domini CASCADE CASCADE;
DROP TABLE applicazioni CASCADE CASCADE;
DROP TABLE stazioni CASCADE CASCADE;
DROP TABLE intermediari CASCADE CASCADE;
DROP TABLE canali CASCADE CASCADE;
DROP TABLE psp CASCADE CASCADE;
DROP SEQUENCE seq_rendicontazioni_senza_rpt CASCADE CASCADE;
DROP SEQUENCE seq_eventi CASCADE CASCADE;
DROP SEQUENCE seq_pagamenti CASCADE CASCADE;
DROP SEQUENCE seq_fr_applicazioni CASCADE CASCADE;
DROP SEQUENCE seq_fr CASCADE CASCADE;
DROP SEQUENCE seq_iuv CASCADE CASCADE;
DROP SEQUENCE seq_notifiche CASCADE CASCADE;
DROP SEQUENCE seq_rr CASCADE CASCADE;
DROP SEQUENCE seq_rpt CASCADE CASCADE;
DROP SEQUENCE seq_singoli_versamenti CASCADE CASCADE;
DROP SEQUENCE seq_versamenti CASCADE CASCADE;
DROP SEQUENCE seq_acl CASCADE CASCADE;
DROP SEQUENCE seq_tributi CASCADE CASCADE;
DROP SEQUENCE seq_tipi_tributo CASCADE CASCADE;
DROP SEQUENCE seq_iban_accredito CASCADE CASCADE;
DROP SEQUENCE seq_portali CASCADE CASCADE;
DROP SEQUENCE seq_connettori CASCADE CASCADE;
DROP SEQUENCE seq_operatori CASCADE CASCADE;
DROP SEQUENCE seq_uo CASCADE CASCADE;
DROP SEQUENCE seq_domini CASCADE CASCADE;
DROP SEQUENCE seq_applicazioni CASCADE CASCADE;
DROP SEQUENCE seq_stazioni CASCADE CASCADE;
DROP SEQUENCE seq_intermediari CASCADE CASCADE;
DROP SEQUENCE seq_canali CASCADE CASCADE;
DROP SEQUENCE seq_psp CASCADE CASCADE;
