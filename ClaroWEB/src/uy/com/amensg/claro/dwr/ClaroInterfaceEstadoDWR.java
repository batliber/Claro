package uy.com.amensg.claro.dwr;

import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.claro.bean.ClaroInterfaceEstadoBean;
import uy.com.amensg.claro.bean.IClaroInterfaceEstadoBean;
import uy.com.amensg.claro.entities.ClaroInterfaceEstado;
import uy.com.amensg.claro.entities.ClaroInterfaceEstadoTO;

@RemoteProxy
public class ClaroInterfaceEstadoDWR {

	private IClaroInterfaceEstadoBean lookupBean() throws NamingException {
		String EARName = "Claro";
		String beanName = ClaroInterfaceEstadoBean.class.getSimpleName();
		String remoteInterfaceName = IClaroInterfaceEstadoBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IClaroInterfaceEstadoBean) context.lookup(lookupName);
	}
	
	public Collection<ClaroInterfaceEstadoTO> list() {
		Collection<ClaroInterfaceEstadoTO> result = new LinkedList<ClaroInterfaceEstadoTO>();
		
		try {
			IClaroInterfaceEstadoBean iClaroInterfaceEstadoBean = lookupBean();
			
			for (ClaroInterfaceEstado acmInterfaceEstado : iClaroInterfaceEstadoBean.list()) {
				result.add(transform(acmInterfaceEstado));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static ClaroInterfaceEstadoTO transform(ClaroInterfaceEstado claroInterfaceEstado) {
		ClaroInterfaceEstadoTO claroInterfaceEstadoTO = new ClaroInterfaceEstadoTO();
		
		claroInterfaceEstadoTO.setDescripcion(claroInterfaceEstado.getDescripcion());
		
		claroInterfaceEstadoTO.setFact(claroInterfaceEstado.getFact());
		claroInterfaceEstadoTO.setId(claroInterfaceEstado.getId());
		claroInterfaceEstadoTO.setTerm(claroInterfaceEstado.getTerm());
		claroInterfaceEstadoTO.setUact(claroInterfaceEstado.getUact());
		
		return claroInterfaceEstadoTO;
	}
}