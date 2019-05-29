package it.govpay.backoffice.v1.controllers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.openspcoop2.utils.serialization.SerializationConfig;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;

import it.govpay.backoffice.v1.beans.Evento;
import it.govpay.backoffice.v1.beans.ListaEventi;
import it.govpay.backoffice.v1.beans.converter.EventiConverter;
import it.govpay.core.autorizzazione.AuthorizationManager;
import it.govpay.core.dao.eventi.EventiDAO;
import it.govpay.core.dao.eventi.dto.ListaEventiDTO;
import it.govpay.core.dao.eventi.dto.ListaEventiDTOResponse;
import it.govpay.core.utils.SimpleDateFormatUtils;
import it.govpay.core.utils.validator.ValidatoreIdentificativi;
import it.govpay.model.Acl.Diritti;
import it.govpay.model.Acl.Servizio;
import it.govpay.model.Utenza.TIPO_UTENZA;



public class EventiController extends BaseController {

	public EventiController(String nomeServizio,Logger log) {
		super(nomeServizio,log);
	}



	public Response eventiGET(Authentication user, UriInfo uriInfo, HttpHeaders httpHeaders , Integer pagina, Integer risultatiPerPagina, String idDominio, String iuv, String idA2A, String idPendenza) {
		String methodName = "eventiGET";  
		String transactionId = this.context.getTransactionId();
		this.log.debug(MessageFormat.format(BaseController.LOG_MSG_ESECUZIONE_METODO_IN_CORSO, methodName)); 
		try{
			// autorizzazione sulla API
			this.isAuthorized(user, Arrays.asList(TIPO_UTENZA.OPERATORE, TIPO_UTENZA.APPLICAZIONE), Arrays.asList(Servizio.GIORNALE_DEGLI_EVENTI), Arrays.asList(Diritti.LETTURA));

			ValidatoreIdentificativi validatoreId = ValidatoreIdentificativi.newInstance();
			if(idDominio != null)
				validatoreId.validaIdDominio("idDominio", idDominio);
			if(idA2A != null)
				validatoreId.validaIdApplicazione("idA2A", idA2A);

			// Parametri - > DTO Input

			ListaEventiDTO listaEventiDTO = new ListaEventiDTO(user);

			listaEventiDTO.setLimit(risultatiPerPagina);
			listaEventiDTO.setPagina(pagina);
			listaEventiDTO.setIdDominio(idDominio);
			listaEventiDTO.setIuv(iuv);
			listaEventiDTO.setIdA2A(idA2A);
			listaEventiDTO.setIdPendenza(idPendenza);


			List<String> domini = null;
			// Autorizzazione sui domini
			domini = AuthorizationManager.getDominiAutorizzati(user);
//			if(domini == null) {
//				throw AuthorizationManager.toNotAuthorizedExceptionNessunDominioAutorizzato(user);
//			}
			listaEventiDTO.setCodDomini(domini);

			EventiDAO pspDAO = new EventiDAO();

			// CHIAMATA AL DAO

			ListaEventiDTOResponse listaEventiDTOResponse = domini != null ?  pspDAO.listaEventi(listaEventiDTO) : new ListaEventiDTOResponse(0, new ArrayList<>());

			// CONVERT TO JSON DELLA RISPOSTA

			List<Evento> results = new ArrayList<>();
			for(it.govpay.bd.model.Evento evento: listaEventiDTOResponse.getResults()) {
				results.add(EventiConverter.toRsModel(evento));
			}

			ListaEventi response = new ListaEventi(results, this.getServicePath(uriInfo),
					listaEventiDTOResponse.getTotalResults(), pagina, risultatiPerPagina);

			SerializationConfig serializationConfig = new SerializationConfig();
			serializationConfig.setExcludes(Arrays.asList("jsonIdFilter"));
			serializationConfig.setDf(SimpleDateFormatUtils.newSimpleDateFormatDataOreMinutiSecondi());

			this.log.debug(MessageFormat.format(BaseController.LOG_MSG_ESECUZIONE_METODO_COMPLETATA, methodName)); 
			return this.handleResponseOk(Response.status(Status.OK).entity(response.toJSON(null,serializationConfig)),transactionId).build();

		}catch (Exception e) {
			return this.handleException(uriInfo, httpHeaders, methodName, e, transactionId);
		} finally {
			this.log(this.context);
		}
	}


}


