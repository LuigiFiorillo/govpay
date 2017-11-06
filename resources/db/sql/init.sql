INSERT INTO operatori (principal,profilo,nome) VALUES ('@PRINCIPAL@','Amministratore','@RAGIONE_SOCIALE@');
INSERT INTO ruoli (cod_ruolo,descrizione) VALUES ('Amministratore', 'Ruolo Amministratore');
INSERT INTO ruoli (cod_ruolo,descrizione) VALUES ('Operatore', 'Ruolo Operatore');
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'A_PPA', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'A_CON', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'A_APP', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'A_USR', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo,amministratore) select 'D', 'G_PAG', 2, id, @BOOLEAN@ from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'G_RND', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'GDE', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'MAN', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'STAT', 2, id from ruoli where cod_ruolo ='Amministratore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'G_PAG', 1, id from ruoli where cod_ruolo ='Operatore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'G_RND', 1, id from ruoli where cod_ruolo ='Operatore';
INSERT INTO acl (cod_tipo,cod_servizio,diritti,id_ruolo) select 'D', 'GDE', 1, id from ruoli where cod_ruolo ='Operatore';

INSERT INTO tipi_tributo (cod_tributo, descrizione) VALUES ('BOLLOT', 'Marca da Bollo Telematica');
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('update-psp', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 86400000, 172800000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('update-rnd', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 18000000, 86400000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('update-pnd', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 7200000, 43200000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('update-ntfy', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 86400000, 172800000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('update-conto', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 86400000, 172800000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('check-ntfy', 'org.openspcoop2.utils.sonde.impl.SondaCoda', 10, 100);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('caricamento-tracciati', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 3600000, 21600000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('check-tracciati', 'org.openspcoop2.utils.sonde.impl.SondaCoda', 1, 1);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('cons-req', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 86400000, 172800000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('cons-esito', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 86400000, 172800000);
insert into sonde(nome, classe, soglia_warn, soglia_error) values ('generazione-avvisi', 'org.openspcoop2.utils.sonde.impl.SondaBatch', 3600000, 21600000);
