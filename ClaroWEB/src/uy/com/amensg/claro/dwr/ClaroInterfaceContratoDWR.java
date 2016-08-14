package uy.com.amensg.claro.dwr;

import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.claro.bean.ClaroInterfaceContratoBean;
import uy.com.amensg.claro.bean.IClaroInterfaceContratoBean;
import uy.com.amensg.claro.entities.ClaroInterfaceContrato;
import uy.com.amensg.claro.entities.ClaroInterfaceContratoTO;
import uy.com.amensg.claro.entities.EmpresaTO;
import uy.com.amensg.claro.entities.MetadataConsultaResultado;
import uy.com.amensg.claro.entities.MetadataConsultaResultadoTO;
import uy.com.amensg.claro.entities.MetadataConsultaTO;

@RemoteProxy
public class ClaroInterfaceContratoDWR {

	private IClaroInterfaceContratoBean lookupBean() throws NamingException {
		String EARName = "Claro";
		String beanName = ClaroInterfaceContratoBean.class.getSimpleName();
		String remoteInterfaceName = IClaroInterfaceContratoBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IClaroInterfaceContratoBean) context.lookup(lookupName);
	}
	
	public MetadataConsultaResultadoTO list(MetadataConsultaTO metadataConsultaTO) {
		MetadataConsultaResultadoTO result = new MetadataConsultaResultadoTO();
		
		try {
			IClaroInterfaceContratoBean iClaroInterfaceContratoBean = lookupBean();
			
			MetadataConsultaResultado metadataConsultaResultado = 
				iClaroInterfaceContratoBean.list(
					MetadataConsultaDWR.transform(
						metadataConsultaTO
					)
				);
			
			Collection<Object> registrosMuestra = new LinkedList<Object>();
			
			for (Object acmInterfaceContrato : metadataConsultaResultado.getRegistrosMuestra()) {
				registrosMuestra.add(transform((ClaroInterfaceContrato) acmInterfaceContrato));
			}
			
			result.setRegistrosMuestra(registrosMuestra);
			
			result.setCantidadRegistros(metadataConsultaResultado.getCantidadRegistros());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String exportarAExcel(MetadataConsultaTO metadataConsultaTO) {
		String result = null;
		
		try {
			HttpSession httpSession = WebContextFactory.get().getSession(false);
			
			if ((httpSession != null) && (httpSession.getAttribute("sesion") != null)) {
				Long usuarioId = (Long) httpSession.getAttribute("sesion");
				
				IClaroInterfaceContratoBean iClaroInterfaceContratoBean = lookupBean();
				
				result = iClaroInterfaceContratoBean.exportarAExcel(MetadataConsultaDWR.transform(metadataConsultaTO), usuarioId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String preprocesarExportacionByEmpresa(MetadataConsultaTO metadataConsultaTO, EmpresaTO empresaTO) {
		String result = null;
		
		try {
			IClaroInterfaceContratoBean iClaroInterfaceContratoBean = lookupBean();
			
			result = iClaroInterfaceContratoBean.preprocesarExportacion(
				MetadataConsultaDWR.transform(
					metadataConsultaTO
				),
				EmpresaDWR.transform(empresaTO)
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String exportarAExcelByEmpresa(MetadataConsultaTO metadataConsultaTO, EmpresaTO empresaTO, String observaciones) {
		String result = null;
		
		try {
			IClaroInterfaceContratoBean iClaroInterfaceContratoBean = lookupBean();
			
			result = iClaroInterfaceContratoBean.exportarAExcel(
				MetadataConsultaDWR.transform(
					metadataConsultaTO
				),
				EmpresaDWR.transform(empresaTO),
				observaciones
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void reprocesar(MetadataConsultaTO metadataConsultaTO, String observaciones) {
		try {
			IClaroInterfaceContratoBean iClaroInterfaceContratoBean = lookupBean();
			
			iClaroInterfaceContratoBean.reprocesar(
				MetadataConsultaDWR.transform(
					metadataConsultaTO
				),
				observaciones
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ClaroInterfaceContratoTO transform(ClaroInterfaceContrato claroInterfaceContrato) {
		ClaroInterfaceContratoTO claroInterfaceContratoTO = new ClaroInterfaceContratoTO();
		
		claroInterfaceContratoTO.setNim(claroInterfaceContrato.getNim());
		
		claroInterfaceContratoTO.setSimCard(claroInterfaceContrato.getSimCard());
		claroInterfaceContratoTO.setTipo(claroInterfaceContrato.getTipo());
		claroInterfaceContratoTO.setIccid(claroInterfaceContrato.getIccid());
		claroInterfaceContratoTO.setImsi(claroInterfaceContrato.getImsi());
		claroInterfaceContratoTO.setEstadoContrato(claroInterfaceContrato.getEstadoContrato());
		claroInterfaceContratoTO.setDescEstadoContrato(claroInterfaceContrato.getDescEstadoContrato());
		claroInterfaceContratoTO.setFormaVenta(claroInterfaceContrato.getFormaVenta());
		claroInterfaceContratoTO.setDuenio(claroInterfaceContrato.getDuenio());
		claroInterfaceContratoTO.setAgente(claroInterfaceContrato.getAgente());
		claroInterfaceContratoTO.setModo(claroInterfaceContrato.getModo());
		claroInterfaceContratoTO.setVigenciaDesde(claroInterfaceContrato.getVigenciaDesde());
		claroInterfaceContratoTO.setTerminal(claroInterfaceContrato.getTerminal());
		claroInterfaceContratoTO.setDescTerminal(claroInterfaceContrato.getDescTerminal());
		claroInterfaceContratoTO.setImei(claroInterfaceContrato.getImei());
		claroInterfaceContratoTO.setEstadoContrato2(claroInterfaceContrato.getEstadoContrato2());
		claroInterfaceContratoTO.setDescEstadoContrato2(claroInterfaceContrato.getDescEstadoContrato2());
		claroInterfaceContratoTO.setfVenta(claroInterfaceContrato.getfVenta());
		claroInterfaceContratoTO.setAgente2(claroInterfaceContrato.getAgente2());
		claroInterfaceContratoTO.setCuentaRemanente(claroInterfaceContrato.getCuentaRemanente());
		claroInterfaceContratoTO.setFechaCreacionRemanente(claroInterfaceContrato.getFechaCreacionRemanente());
		claroInterfaceContratoTO.setMontoSubsidiario(claroInterfaceContrato.getMontoSubsidiario());
		claroInterfaceContratoTO.setProductoRemanente(claroInterfaceContrato.getProductoRemanente());
		claroInterfaceContratoTO.setDescProductoRemanente(claroInterfaceContrato.getDescProductoRemanente());
		claroInterfaceContratoTO.setImeiRemanente(claroInterfaceContrato.getImeiRemanente());
		claroInterfaceContratoTO.setEstadoRemanente(claroInterfaceContrato.getEstadoRemanente());
		claroInterfaceContratoTO.setNumeralIsrRemanente(claroInterfaceContrato.getNumeralIsrRemanente());
		claroInterfaceContratoTO.setNumeralActivoRemanente(claroInterfaceContrato.getNumeralActivoRemanente());
		claroInterfaceContratoTO.setNumeralCarterRemanente(claroInterfaceContrato.getNumeralCarterRemanente());
		claroInterfaceContratoTO.setAcreditableRemanente(claroInterfaceContrato.getAcreditableRemanente());
		claroInterfaceContratoTO.setEstadoGeneral(claroInterfaceContrato.getEstadoGeneral());
		claroInterfaceContratoTO.setVigenciaDesde2(claroInterfaceContrato.getVigenciaDesde2());
		
		claroInterfaceContratoTO.setFact(claroInterfaceContrato.getFact());
		claroInterfaceContratoTO.setUact(claroInterfaceContrato.getUact());
		claroInterfaceContratoTO.setTerm(claroInterfaceContrato.getTerm());
		
		return claroInterfaceContratoTO;
	}
}