/**
 * 
 */
package it.govpay.rs.v1.beans.converter;

import java.util.ArrayList;
import java.util.List;

import org.openspcoop2.generic_project.exception.ServiceException;

import it.govpay.bd.model.Dominio;
import it.govpay.bd.model.Tributo;
import it.govpay.core.dao.anagrafica.dto.LeggiProfiloDTOResponse;
import it.govpay.core.rs.v1.beans.base.AclPost;
import it.govpay.core.rs.v1.beans.base.DominioIndex;
import it.govpay.core.rs.v1.beans.base.Profilo;
import it.govpay.core.rs.v1.beans.base.TipoEntrata;
import it.govpay.model.Acl;
import it.govpay.model.IAutorizzato;

/**
 * @author Bussu Giovanni (bussu@link.it)
 * @author  $Author: bussu $
 * @version $ Rev: 12563 $, $Date: 12 giu 2018 $
 * 
 */
public class ProfiloConverter {

	/**
	 * @param user
	 * @return
	 * @throws ServiceException 
	 */
	public static Profilo getProfilo(LeggiProfiloDTOResponse leggiProfilo) throws ServiceException {
		Profilo profilo = new Profilo();
		
		IAutorizzato user = leggiProfilo.getUtente();
		if(user.getAcls()!=null) {
			List<AclPost> aclLst = new ArrayList<AclPost>();
			for(Acl acl: user.getAcls()) {
				aclLst.add(AclConverter.toRsModel(acl));

			}
			profilo.setAcl(aclLst);
		}
		profilo.setNome(leggiProfilo.getNome());
		if(leggiProfilo.getDomini()!=null) {
			List<DominioIndex> dominiLst = new ArrayList<>();
			for(Dominio dominio: leggiProfilo.getDomini()) {
				dominiLst.add(DominiConverter.toRsModelIndex(dominio));
			}
			profilo.setDomini(dominiLst);
		}
		if(leggiProfilo.getTributi()!=null) {
			List<TipoEntrata> entrateLst = new ArrayList<>();
			for(Tributo tributo: leggiProfilo.getTributi()) {
				entrateLst.add(EntrateConverter.toTipoEntrataRsModel(tributo));
			}
			profilo.setEntrate(entrateLst);
		}
		return profilo;
	}

}
