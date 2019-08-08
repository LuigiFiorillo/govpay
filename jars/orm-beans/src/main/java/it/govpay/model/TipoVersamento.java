package it.govpay.model;

import org.apache.commons.lang.ArrayUtils;
import org.openspcoop2.generic_project.exception.ServiceException;

public class TipoVersamento extends BasicModel {
	private static final long serialVersionUID = 1L;

	public enum Tipo {
		SPONTANEO("SPONTANEO"),
		DOVUTO("DOVUTO");

		private String codifica;

		Tipo(String codifica) {
			this.codifica = codifica;
		}
		public String getCodifica() {
			return this.codifica;
		}

		public static Tipo toEnum(String codifica) throws ServiceException {
			for(Tipo p : Tipo.values()){
				if(p.getCodifica().equals(codifica))
					return p;
			}
			throw new ServiceException("Codifica inesistente per Tipo. Valore fornito [" + codifica + "] valori possibili " + ArrayUtils.toString(Tipo.values()));
		}
	}



	private Long id; 
	private String codTipoVersamento;
	private String descrizione;
	private String codificaIuvDefault;
	private Tipo tipoDefault;
	private boolean pagaTerziDefault;
	private boolean abilitatoDefault;
	private String formTipoDefault;
	private String formDefinizioneDefault;
	private String validazioneDefinizioneDefault;
	private String trasformazioneTipoDefault;
	private String trasformazioneDefinizioneDefault;
	private String codApplicazioneDefault;
	private String promemoriaAvvisoTipoDefault;
	private boolean promemoriaAvvisoPdfDefault;
	private String promemoriaAvvisoOggettoDefault;
	private String promemoriaAvvisoMessaggioDefault;
	private String promemoriaRicevutaTipoDefault;
	private boolean promemoriaRicevutaPdfDefault;
	private String promemoriaRicevutaOggettoDefault;
	private String promemoriaRicevutaMessaggioDefault;
	private String visualizzazioneDefinizioneDefault;
	private String tracciatoCsvHeaderRispostaDefault;
	private String tracciatoCsvFreemarkerRichiestaDefault;
	private String tracciatoCsvFreemarkerRispostaDefault;

	public String getCodificaIuvDefault() {
		return codificaIuvDefault;
	}
	public void setCodificaIuvDefault(String codificaIuvDefault) {
		this.codificaIuvDefault = codificaIuvDefault;
	}
	public Tipo getTipoDefault() {
		return tipoDefault;
	}
	public void setTipoDefault(Tipo tipoDefault) {
		this.tipoDefault = tipoDefault;
	}
	public boolean getPagaTerziDefault() {
		return pagaTerziDefault;
	}
	public void setPagaTerziDefault(boolean pagaTerziDefault) {
		this.pagaTerziDefault = pagaTerziDefault;
	}
	@Override
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodTipoVersamento() {
		return codTipoVersamento;
	}
	public void setCodTipoVersamento(String codTipoVersamento) {
		this.codTipoVersamento = codTipoVersamento;
	}
	public String getDescrizione() {
		return this.descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isAbilitatoDefault() {
		return abilitatoDefault;
	}
	public void setAbilitatoDefault(boolean abilitatoDefault) {
		this.abilitatoDefault = abilitatoDefault;
	}
	public String getFormTipoDefault() {
		return formTipoDefault;
	}
	public void setFormTipoDefault(String formTipoDefault) {
		this.formTipoDefault = formTipoDefault;
	}
	public String getFormDefinizioneDefault() {
		return formDefinizioneDefault;
	}
	public void setFormDefinizioneDefault(String formDefinizioneDefault) {
		this.formDefinizioneDefault = formDefinizioneDefault;
	}
	public String getValidazioneDefinizioneDefault() {
		return validazioneDefinizioneDefault;
	}
	public void setValidazioneDefinizioneDefault(String validazioneDefinizioneDefault) {
		this.validazioneDefinizioneDefault = validazioneDefinizioneDefault;
	}
	public String getTrasformazioneTipoDefault() {
		return trasformazioneTipoDefault;
	}
	public void setTrasformazioneTipoDefault(String trasformazioneTipoDefault) {
		this.trasformazioneTipoDefault = trasformazioneTipoDefault;
	}
	public String getTrasformazioneDefinizioneDefault() {
		return trasformazioneDefinizioneDefault;
	}
	public void setTrasformazioneDefinizioneDefault(String trasformazioneDefinizioneDefault) {
		this.trasformazioneDefinizioneDefault = trasformazioneDefinizioneDefault;
	}
	public String getCodApplicazioneDefault() {
		return codApplicazioneDefault;
	}
	public void setCodApplicazioneDefault(String codApplicazioneDefault) {
		this.codApplicazioneDefault = codApplicazioneDefault;
	}
	public boolean getPromemoriaAvvisoPdfDefault() {
		return promemoriaAvvisoPdfDefault;
	}
	public void setPromemoriaAvvisoPdfDefault(boolean promemoriaAvvisoPdfDefault) {
		this.promemoriaAvvisoPdfDefault = promemoriaAvvisoPdfDefault;
	}
	public String getPromemoriaAvvisoOggettoDefault() {
		return promemoriaAvvisoOggettoDefault;
	}
	public void setPromemoriaAvvisoOggettoDefault(String promemoriaAvvisoOggettoDefault) {
		this.promemoriaAvvisoOggettoDefault = promemoriaAvvisoOggettoDefault;
	}
	public String getPromemoriaAvvisoMessaggioDefault() {
		return promemoriaAvvisoMessaggioDefault;
	}
	public void setPromemoriaAvvisoMessaggioDefault(String promemoriaAvvisoMessaggioDefault) {
		this.promemoriaAvvisoMessaggioDefault = promemoriaAvvisoMessaggioDefault;
	}
	public boolean getPromemoriaRicevutaPdfDefault() {
		return promemoriaRicevutaPdfDefault;
	}
	public void setPromemoriaRicevutaPdfDefault(boolean promemoriaRicevutaPdfDefault) {
		this.promemoriaRicevutaPdfDefault = promemoriaRicevutaPdfDefault;
	}
	public String getPromemoriaRicevutaOggettoDefault() {
		return promemoriaRicevutaOggettoDefault;
	}
	public void setPromemoriaRicevutaOggettoDefault(String promemoriaRicevutaOggettoDefault) {
		this.promemoriaRicevutaOggettoDefault = promemoriaRicevutaOggettoDefault;
	}
	public String getPromemoriaRicevutaMessaggioDefault() {
		return promemoriaRicevutaMessaggioDefault;
	}
	public void setPromemoriaRicevutaMessaggioDefault(String promemoriaRicevutaMessaggioDefault) {
		this.promemoriaRicevutaMessaggioDefault = promemoriaRicevutaMessaggioDefault;
	}
	public String getPromemoriaAvvisoTipoDefault() {
		return promemoriaAvvisoTipoDefault;
	}
	public void setPromemoriaAvvisoTipoDefault(String promemoriaAvvisoTipoDefault) {
		this.promemoriaAvvisoTipoDefault = promemoriaAvvisoTipoDefault;
	}
	public String getPromemoriaRicevutaTipoDefault() {
		return promemoriaRicevutaTipoDefault;
	}
	public void setPromemoriaRicevutaTipoDefault(String promemoriaRicevutaTipoDefault) {
		this.promemoriaRicevutaTipoDefault = promemoriaRicevutaTipoDefault;
	}
	public String getVisualizzazioneDefinizioneDefault() {
		return visualizzazioneDefinizioneDefault;
	}
	public void setVisualizzazioneDefinizioneDefault(String visualizzazioneDefinizioneDefault) {
		this.visualizzazioneDefinizioneDefault = visualizzazioneDefinizioneDefault;
	}
	public String getTracciatoCsvHeaderRispostaDefault() {
		return tracciatoCsvHeaderRispostaDefault;
	}
	public void setTracciatoCsvHeaderRispostaDefault(String tracciatoCsvHeaderRispostaDefault) {
		this.tracciatoCsvHeaderRispostaDefault = tracciatoCsvHeaderRispostaDefault;
	}
	public String getTracciatoCsvFreemarkerRichiestaDefault() {
		return tracciatoCsvFreemarkerRichiestaDefault;
	}
	public void setTracciatoCsvFreemarkerRichiestaDefault(String tracciatoCsvFreemarkerRichiestaDefault) {
		this.tracciatoCsvFreemarkerRichiestaDefault = tracciatoCsvFreemarkerRichiestaDefault;
	}
	public String getTracciatoCsvFreemarkerRispostaDefault() {
		return tracciatoCsvFreemarkerRispostaDefault;
	}
	public void setTracciatoCsvFreemarkerRispostaDefault(String tracciatoCsvFreemarkerRispostaDefault) {
		this.tracciatoCsvFreemarkerRispostaDefault = tracciatoCsvFreemarkerRispostaDefault;
	}

}
