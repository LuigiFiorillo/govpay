package it.govpay.bd.nativequeries;

public class PostgresNativeQueries extends NativeQueries {

	@Override
	public String getEstrattiContoQuery() {
		return "SELECT id_pagamento, id_singolo_versamento, id_versamento, data_pagamento, importo_dovuto, importo_pagato, iuv, iur1, f.iur as iur2, f.cod_flusso as cod_flusso_rendicontazione, f.cod_bic_riversamento as cod_bic_riversamento, cod_versamento_ente, stato_versamento, cod_singolo_versamento_ente, stato_singolo_versamento, iban_accredito, debitore_identificativo, note, causale_versamento FROM ( SELECT id_pagamento, id_singolo_versamento, id_versamento, id_fr_applicazione, data_pagamento, importo_pagato, iur1, iuv, iban_accredito, cod_singolo_versamento_ente, note, cod_versamento_ente, stato_versamento, causale_versamento, debitore_identificativo, importo_dovuto, stato_singolo_versamento FROM ( ( select p.id as id_pagamento, p.id_singolo_versamento as id_singolo_versamento, p.id_fr_applicazione as id_fr_applicazione, p.data_pagamento as data_pagamento, p.importo_pagato as importo_pagato, p.iur as iur1, r.iuv as iuv, p.iban_accredito as iban_accredito, sv.cod_singolo_versamento_ente as cod_singolo_versamento_ente, sv.note as note, v.id as id_versamento, v.cod_versamento_ente as cod_versamento_ente, v.stato_versamento as stato_versamento, v.causale_versamento as causale_versamento, v.debitore_identificativo as debitore_identificativo, sv.importo_singolo_versamento as importo_dovuto, sv.stato_singolo_versamento as stato_singolo_versamento from pagamenti p join rpt r on r.id=p.id_rpt join singoli_versamenti sv on sv.id= p.id_singolo_versamento join versamenti v on v.id = sv.id_versamento $PLACE_HOLDER_1$ ) UNION ALL ( select rsr.id as id_pagamento, rsr.id_singolo_versamento as id_singolo_versamento, rsr.id_fr_applicazione as id_fr_applicazione, rsr.rendicontazione_data as data_pagamento, rsr.importo_pagato as importo_pagato, rsr.iur as iur1, iu.iuv as iuv, '' as iban_accredito, sv.cod_singolo_versamento_ente as cod_singolo_versamento_ente, sv.note as note, v.id as id_versamento, v.cod_versamento_ente as cod_versamento_ente, v.stato_versamento as stato_versamento, v.causale_versamento as causale_versamento, v.debitore_identificativo as debitore_identificativo, sv.importo_singolo_versamento as importo_dovuto, sv.stato_singolo_versamento as stato_singolo_versamento from rendicontazioni_senza_rpt rsr join iuv iu on iu.id=rsr.id_iuv join singoli_versamenti sv on sv.id= rsr.id_singolo_versamento join versamenti v on v.id = sv.id_versamento $PLACE_HOLDER_2$ ) ) as subquery1 order by iuv ASC, data_pagamento ASC ) pag left outer join fr_applicazioni fra on pag.id_fr_applicazione=fra.id left outer join fr f on f.id=fra.id_fr order by cod_flusso_rendicontazione, iuv, data_pagamento OFFSET ? LIMIT ?";
	}

	@Override
	public String getEstrattiContoCountQuery() {
		return "SELECT sum (count_id_pagamento) as totale_pagamenti FROM ( ( select count (p.id) as count_id_pagamento from pagamenti p join rpt r on r.id=p.id_rpt join singoli_versamenti sv on sv.id= p.id_singolo_versamento join versamenti v on v.id = sv.id_versamento $PLACE_HOLDER_1$ ) UNION ALL ( select count (rsr.id) as count_id_pagamento from rendicontazioni_senza_rpt rsr join iuv iu on iu.id=rsr.id_iuv join singoli_versamenti sv on sv.id= rsr.id_singolo_versamento join versamenti v on v.id = sv.id_versamento $PLACE_HOLDER_2$ ) ) as subquery1";
	}

}