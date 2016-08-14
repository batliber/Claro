package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.ClaroInterfaceProceso;
import uy.com.amensg.claro.entities.ClaroInterfaceProcesoEstadistica;

@Remote
public interface IClaroInterfaceProcesoBean {

	public Collection<ClaroInterfaceProcesoEstadistica> listEstadisticas();
	
	public ClaroInterfaceProceso save(ClaroInterfaceProceso acmInterfaceProceso);
	
	public void finalizarProcesos();
}