package it.govpay.bd.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtenzaCittadino extends Utenza {

	public UtenzaCittadino(String codIdentificativo) {
		this(codIdentificativo, new HashMap<>());
	}
	
	public UtenzaCittadino(String codIdentificativo,Map<String, List<String>> headers) {
		super();
		this.setCodIdentificativo(codIdentificativo); 
		this.setIdDomini(new ArrayList<>());
		this.setIdTipiVersamento(new ArrayList<>());
		this.setDomini(new ArrayList<>());
		this.setTipiVersamento(new ArrayList<>());
		this.autorizzazioneDominiStar = true ;
		this.autorizzazioneTipiVersamentoStar = false;
		this.headers = headers;
	}
	
	private static final long serialVersionUID = 1L;
	
	private transient String codIdentificativo;
	private transient Map<String, List<String>> headers;

	public String getCodIdentificativo() {
		return codIdentificativo;
	}

	public void setCodIdentificativo(String codIdentificativo) {
		this.codIdentificativo = codIdentificativo;
	}
	
	@Override
	public TIPO_UTENZA getTipoUtenza() {
		return TIPO_UTENZA.CITTADINO;
	}

	@Override
	public String getIdentificativo() {
		return this.getCodIdentificativo();
	}
	
	public String getProprieta(String nome) {
		if(headers.containsKey(nome))
			if(!headers.get(nome).isEmpty())
				return headers.get(nome).get(0);
		
		return null;
	}
	
	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, List<String>> headers) {
		this.headers = headers;
	}

}
