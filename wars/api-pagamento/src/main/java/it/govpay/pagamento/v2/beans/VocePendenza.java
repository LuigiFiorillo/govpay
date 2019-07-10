package it.govpay.pagamento.v2.beans;

import java.math.BigDecimal;
import java.util.Objects;

import org.openspcoop2.utils.json.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.govpay.core.beans.JSONSerializable;
import it.govpay.core.utils.validator.IValidable;
import it.govpay.core.utils.validator.ValidatorFactory;
@com.fasterxml.jackson.annotation.JsonPropertyOrder({
	"indice",
	"idVocePendenza",
	"importo",
	"descrizione",
	"stato",
	"datiAllegati",
	"hashDocumento",
	"tipoBollo",
	"provinciaResidenza",
	"codEntrata",
	"codiceContabilita",
	"ibanAccredito",
	"ibanAppoggio",
	"tipoContabilita",
})
public class VocePendenza extends JSONSerializable implements IValidable {

	@JsonProperty("indice")
	private BigDecimal indice = null;

	@JsonProperty("idVocePendenza")
	private String idVocePendenza = null;

	@JsonProperty("importo")
	private BigDecimal importo = null;

	@JsonProperty("descrizione")
	private String descrizione = null;


	/**
	 * Stato della voce di pagamento
	 */
	public enum StatoEnum {




		ESEGUITO("Eseguito"),


		NON_ESEGUITO("Non eseguito"),


		ANOMALO("Anomalo");




		private String value;

		StatoEnum(String value) {
			this.value = value;
		}

		@Override
		@com.fasterxml.jackson.annotation.JsonValue
		public String toString() {
			return String.valueOf(this.value);
		}

		public static StatoEnum fromValue(String text) {
			for (StatoEnum b : StatoEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}



	@JsonProperty("stato")
	private StatoEnum stato = null;

	@JsonProperty("datiAllegati")
	private Object datiAllegati = null;

	@JsonProperty("hashDocumento")
	private String hashDocumento= null;

	public enum TipoBolloEnum {


		IMPOSTA_DI_BOLLO("Imposta di bollo");


		private String value;


		TipoBolloEnum(String value) {
			this.value = value;
		}

		@Override
		@com.fasterxml.jackson.annotation.JsonValue
		public String toString() {
			return String.valueOf(this.value);
		}

		public String getCodifica() {
			switch (this) {
			case IMPOSTA_DI_BOLLO:
			default:
				return "01";
			}
		}
		
		public static TipoBolloEnum fromCodifica(String codifica) {
			switch (codifica) {
			case "01":
			default:
				return IMPOSTA_DI_BOLLO;
			}
		}

		public static TipoBolloEnum fromValue(String text) {
			for (TipoBolloEnum b : TipoBolloEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("tipoBollo")
	private TipoBolloEnum tipoBollo= null;

	@JsonProperty("provinciaResidenza")
	private String provinciaResidenza= null;

	@JsonProperty("codEntrata")
	private String codEntrata= null;

	@JsonProperty("codiceContabilita")
	private String codiceContabilita= null;

	@JsonProperty("ibanAccredito")
	private String ibanAccredito= null;

	@JsonProperty("ibanAppoggio")
	private String ibanAppoggio= null;

	public enum TipoContabilitaEnum {


		CAPITOLO("CAPITOLO"), SPECIALE("SPECIALE"), SIOPE("SIOPE"), ALTRO("ALTRO");


		private String value;

		TipoContabilitaEnum(String value) {
			this.value = value;
		}

		@Override
		@com.fasterxml.jackson.annotation.JsonValue
		public String toString() {
			return String.valueOf(this.value);
		}

		public static TipoContabilitaEnum fromValue(String text) {
			for (TipoContabilitaEnum b : TipoContabilitaEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("tipoContabilita")
	private TipoContabilitaEnum tipoContabilita= null;

	/**
	 * indice di voce all'interno della pendenza
	 **/
	public VocePendenza indice(BigDecimal indice) {
		this.indice = indice;
		return this;
	}

	@JsonProperty("indice")
	public BigDecimal getIndice() {
		return this.indice;
	}
	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}

	/**
	 * Identificativo della voce di pedenza nel gestionale proprietario
	 **/
	public VocePendenza idVocePendenza(String idVocePendenza) {
		this.idVocePendenza = idVocePendenza;
		return this;
	}

	@JsonProperty("idVocePendenza")
	public String getIdVocePendenza() {
		return this.idVocePendenza;
	}
	public void setIdVocePendenza(String idVocePendenza) {
		this.idVocePendenza = idVocePendenza;
	}

	/**
	 * Importo della voce
	 **/
	public VocePendenza importo(BigDecimal importo) {
		this.importo = importo;
		return this;
	}

	@JsonProperty("importo")
	public BigDecimal getImporto() {
		return this.importo;
	}
	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	/**
	 * descrizione della voce di pagamento
	 **/
	public VocePendenza descrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	@JsonProperty("descrizione")
	public String getDescrizione() {
		return this.descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Stato della voce di pagamento
	 **/
	public VocePendenza stato(StatoEnum stato) {
		this.stato = stato;
		return this;
	}

	@JsonProperty("stato")
	public StatoEnum getStato() {
		return this.stato;
	}
	public void setStato(StatoEnum stato) {
		this.stato = stato;
	}

	/**
	 * Dati applicativi allegati dal gestionale secondo un formato proprietario.
	 **/
	public VocePendenza datiAllegati(Object datiAllegati) {
		this.datiAllegati = datiAllegati;
		return this;
	}

	@JsonProperty("datiAllegati")
	public Object getDatiAllegati() {
		return this.datiAllegati;
	}
	public void setDatiAllegati(Object datiAllegati) {
		this.datiAllegati = datiAllegati;
	}

	public VocePendenza hashDocumento(String hashDocumento) {
		this.hashDocumento = hashDocumento;
		return this;
	}

	@JsonProperty("hashDocumento")
	public String getHashDocumento() {
		return this.hashDocumento;
	}
	public void setHashDocumento(String hashDocumento) {
		this.hashDocumento = hashDocumento;
	}

	/**
	 * Stato della voce di pagamento
	 **/
	public VocePendenza tipoBollo(TipoBolloEnum tipoBollo) {
		this.tipoBollo = tipoBollo;
		return this;
	}

	@JsonProperty("tipoBollo")
	public TipoBolloEnum getTipoBollo() {
		return this.tipoBollo;
	}
	public void setTipoBollo(TipoBolloEnum tipoBollo) {
		this.tipoBollo = tipoBollo;
	}

	public VocePendenza codEntrata(String codEntrata) {
		this.codEntrata = codEntrata;
		return this;
	}

	@JsonProperty("codEntrata")
	public String getCodEntrata() {
		return this.codEntrata;
	}
	public void setCodEntrata(String codEntrata) {
		this.codEntrata= codEntrata;
	}

	public VocePendenza provinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
		return this;
	}

	@JsonProperty("provinciaResidenza")
	public String getProvinciaResidenza() {
		return this.provinciaResidenza;
	}
	public void setProvinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}

	public VocePendenza codiceContabilita(String codiceContabilita) {
		this.codiceContabilita= codiceContabilita;
		return this;
	}

	@JsonProperty("codiceContabilita")
	public String getCodiceContabilita() {
		return this.codiceContabilita;
	}
	public void setCodiceContabilita(String CodiceContabilita) {
		this.codiceContabilita = CodiceContabilita;
	}

	public VocePendenza ibanAccredito(String ibanAccredito) {
		this.ibanAccredito= ibanAccredito;
		return this;
	}

	@JsonProperty("ibanAccredito")
	public String getIbanAccredito() {
		return this.ibanAccredito;
	}
	public void setIbanAccredito(String ibanAccredito) {
		this.ibanAccredito = ibanAccredito;
	}

	public VocePendenza ibanAppoggio(String ibanAppoggio) {
		this.ibanAppoggio= ibanAppoggio;
		return this;
	}

	@JsonProperty("ibanAppoggio")
	public String getIbanAppoggio() {
		return this.ibanAppoggio;
	}
	public void setIbanAppoggio(String ibanAppoggio) {
		this.ibanAppoggio = ibanAppoggio;
	}

	public VocePendenza tipoContabilita(TipoContabilitaEnum tipoContabilita) {
		this.tipoContabilita= tipoContabilita;
		return this;
	}

	@JsonProperty("tipoContabilita")
	public TipoContabilitaEnum getTipoContabilita() {
		return this.tipoContabilita;
	}
	public void setTipoContabilita(TipoContabilitaEnum tipoContabilita) {
		this.tipoContabilita = tipoContabilita;
	}
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		VocePendenza vocePendenza = (VocePendenza) o;
		return Objects.equals(this.indice, vocePendenza.indice) &&
				Objects.equals(this.idVocePendenza, vocePendenza.idVocePendenza) &&
				Objects.equals(this.importo, vocePendenza.importo) &&
				Objects.equals(this.descrizione, vocePendenza.descrizione) &&
				Objects.equals(this.stato, vocePendenza.stato) &&
				Objects.equals(this.datiAllegati, vocePendenza.datiAllegati) &&
				Objects.equals(this.hashDocumento, vocePendenza.hashDocumento) &&
				Objects.equals(this.tipoBollo, vocePendenza.tipoBollo) &&
				Objects.equals(this.provinciaResidenza, vocePendenza.provinciaResidenza) &&
				Objects.equals(this.codiceContabilita, vocePendenza.codiceContabilita) &&
				Objects.equals(this.ibanAccredito, vocePendenza.ibanAccredito) &&
				Objects.equals(this.ibanAppoggio, vocePendenza.ibanAppoggio) &&
				Objects.equals(this.tipoContabilita, vocePendenza.tipoContabilita);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.indice, this.idVocePendenza, this.importo, this.descrizione, this.stato, this.datiAllegati, this.hashDocumento, this.tipoBollo, this.provinciaResidenza, this.codiceContabilita, this.ibanAccredito, this.ibanAppoggio, this.tipoContabilita);
	}

	public static VocePendenza parse(String json) throws org.openspcoop2.generic_project.exception.ServiceException, org.openspcoop2.utils.json.ValidationException {
		return parse(json, VocePendenza.class);
	}

	@Override
	public String getJsonIdFilter() {
		return "vocePendenza";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VocePendenza {\n");

		sb.append("    indice: ").append(this.toIndentedString(this.indice)).append("\n");
		sb.append("    idVocePendenza: ").append(this.toIndentedString(this.idVocePendenza)).append("\n");
		sb.append("    importo: ").append(this.toIndentedString(this.importo)).append("\n");
		sb.append("    descrizione: ").append(this.toIndentedString(this.descrizione)).append("\n");
		sb.append("    stato: ").append(this.toIndentedString(this.stato)).append("\n");
		sb.append("    datiAllegati: ").append(this.toIndentedString(this.datiAllegati)).append("\n");
		sb.append("    hashDocumento: ").append(this.toIndentedString(this.hashDocumento)).append("\n");
		sb.append("    tipoBollo: ").append(this.toIndentedString(this.tipoBollo)).append("\n");
		sb.append("    provinciaResidenza: ").append(this.toIndentedString(this.provinciaResidenza)).append("\n");
		sb.append("    codiceContabilita: ").append(this.toIndentedString(this.codiceContabilita)).append("\n");
		sb.append("    ibanAccredito: ").append(this.toIndentedString(this.ibanAccredito)).append("\n");
		sb.append("    ibanAppoggio: ").append(this.toIndentedString(this.ibanAppoggio)).append("\n");
		sb.append("    tipoContabilita: ").append(this.toIndentedString(this.tipoContabilita)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public void validate() throws ValidationException {
		ValidatorFactory vf = ValidatorFactory.newInstance();

		vf.getValidator("idVocePendenza", this.idVocePendenza).notNull().minLength(1).maxLength(35);
		vf.getValidator("importo", this.importo).notNull().minOrEquals(BigDecimal.ZERO).maxOrEquals(BigDecimal.valueOf(999999.99)).checkDecimalDigits();
		vf.getValidator("descrizione", this.descrizione).notNull().minLength(1).maxLength(255);

		if(this.codEntrata != null) {
			vf.getValidator("codEntrata", this.codEntrata).notNull().minLength(1).maxLength(35);
			try {
				vf.getValidator("tipoBollo", this.tipoBollo).isNull();
				vf.getValidator("hashDocumento", this.hashDocumento).isNull();
				vf.getValidator("provinciaResidenza", this.provinciaResidenza).isNull();
				vf.getValidator("ibanAccredito", this.ibanAccredito).isNull();
				vf.getValidator("ibanAppoggio", this.ibanAppoggio).isNull();
				vf.getValidator("tipoContabilita", this.tipoContabilita).isNull();
				vf.getValidator("codiceContabilita", this.codiceContabilita).isNull();
			} catch (ValidationException ve) {
				throw new ValidationException("Valorizzato codEntrata. " + ve.getMessage());
			}

			return;
		}

		else if(this.tipoBollo != null) {
			vf.getValidator("tipoBollo", this.tipoBollo).notNull();
			vf.getValidator("hashDocumento", this.hashDocumento).notNull().minLength(1).maxLength(70);
			vf.getValidator("provinciaResidenza", this.provinciaResidenza).notNull().pattern("[A-Z]{2,2}");

			try {
				vf.getValidator("ibanAccredito", this.ibanAccredito).isNull();
				vf.getValidator("ibanAppoggio", this.ibanAppoggio).isNull();
				vf.getValidator("tipoContabilita", this.tipoContabilita).isNull();
				vf.getValidator("codiceContabilita", this.codiceContabilita).isNull();
			} catch (ValidationException ve) {
				throw new ValidationException("Valorizzato tipoBollo. " + ve.getMessage());
			}

			return;
		}


		else if(this.ibanAccredito != null) {
			vf.getValidator("ibanAccredito", this.ibanAccredito).notNull().pattern("[a-zA-Z]{2,2}[0-9]{2,2}[a-zA-Z0-9]{1,30}");
			vf.getValidator("ibanAppoggio", this.ibanAppoggio).pattern("[a-zA-Z]{2,2}[0-9]{2,2}[a-zA-Z0-9]{1,30}");
			vf.getValidator("tipoContabilita", this.tipoContabilita).notNull();
			vf.getValidator("codiceContabilita", this.codiceContabilita).notNull().pattern("\\S{3,138}").maxLength(255);

			try {
				vf.getValidator("hashDocumento", this.hashDocumento).isNull();
				vf.getValidator("provinciaResidenza", this.provinciaResidenza).isNull();
			} catch (ValidationException ve) {
				throw new ValidationException("Valorizzato ibanAccredito. " + ve.getMessage());
			}
		}
		
		else {
			throw new ValidationException("Nella voce di pendenza deve essere valorizzato uno tra codEntrata, tipoBollo o ibanAccredito.");
		}

	}
}


