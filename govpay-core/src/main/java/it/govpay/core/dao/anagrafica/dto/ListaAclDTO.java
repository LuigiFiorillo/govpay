package it.govpay.core.dao.anagrafica.dto;

import java.util.List;

import it.govpay.model.Acl.Diritti;
import it.govpay.model.IAutorizzato;
import it.govpay.orm.ACL;

public class ListaAclDTO extends BasicFindRequestDTO{

	private String principal;
	private Boolean forcePrincipal;
	private String ruolo;
	private Boolean forceRuolo;
	private String servizio;
	private Boolean forceServizio;
	private List<Diritti> diritti;
	
	public Boolean getForcePrincipal() {
		return forcePrincipal;
	}


	public void setForcePrincipal(Boolean forcePrincipal) {
		this.forcePrincipal = forcePrincipal;
	}


	public Boolean getForceRuolo() {
		return forceRuolo;
	}


	public void setForceRuolo(Boolean forceRuolo) {
		this.forceRuolo = forceRuolo;
	}


	public String getPrincipal() {
		return principal;
	}


	public void setPrincipal(String principal) {
		this.principal = principal;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	public String getServizio() {
		return servizio;
	}


	public void setServizio(String servizio) {
		this.servizio = servizio;
	}


	public List<Diritti> getDiritti() {
		return diritti;
	}


	public void setDiritti(List<Diritti> diritti) {
		this.diritti = diritti;
	}


	public ListaAclDTO(IAutorizzato user) {
		super(user);
		this.addSortField("principal", ACL.model().PRINCIPAL);
		this.addSortField("ruolo", ACL.model().RUOLO);
		this.addSortField("servizio", ACL.model().SERVIZIO);
	}


	public Boolean getForceServizio() {
		return forceServizio;
	}


	public void setForceServizio(Boolean forceServizio) {
		this.forceServizio = forceServizio;
	}
}
