package uy.com.amensg.claro.bean;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import uy.com.amensg.claro.entities.ClaroInterfaceProceso;
import uy.com.amensg.claro.entities.ClaroInterfaceProcesoEstadistica;
import uy.com.amensg.claro.util.Configuration;

@Stateless
public class ClaroInterfaceProcesoBean implements IClaroInterfaceProcesoBean {

	@PersistenceContext(unitName = "uy.com.amensg.claro.persistenceUnit")
	private EntityManager entityManager;
	
	public Collection<ClaroInterfaceProcesoEstadistica> listEstadisticas() {
		Collection<ClaroInterfaceProcesoEstadistica> result = new LinkedList<ClaroInterfaceProcesoEstadistica>();
		
		try {
			TypedQuery<ClaroInterfaceProceso> queryProceso = entityManager.createQuery(
				"SELECT p FROM ClaroInterfaceProceso p",
				ClaroInterfaceProceso.class
			);
			
			Map<Long, ClaroInterfaceProcesoEstadistica> estadisticas = new HashMap<Long, ClaroInterfaceProcesoEstadistica>();
			for (ClaroInterfaceProceso acmInterfaceProceso : queryProceso.getResultList()) {
				ClaroInterfaceProcesoEstadistica acmInterfaceProcesoEstadistica = new ClaroInterfaceProcesoEstadistica();
				acmInterfaceProcesoEstadistica.setFechaFin(acmInterfaceProceso.getFechaFin());
				acmInterfaceProcesoEstadistica.setFechaInicio(acmInterfaceProceso.getFechaInicio());
				acmInterfaceProcesoEstadistica.setId(acmInterfaceProceso.getId());
				acmInterfaceProcesoEstadistica.setObservaciones(acmInterfaceProceso.getObservaciones());
				
				estadisticas.put(acmInterfaceProceso.getId(), acmInterfaceProcesoEstadistica);
			}
			
			Query queryNim = entityManager.createQuery(
				"SELECT m.procesoId, m.estado.id, count(m)"
				+ " FROM ClaroInterfaceNim m"
				+ " GROUP BY m.procesoId, m.estado"
			);
			
			for (Object object : queryNim.getResultList()) {
				Object[] queryResult = (Object[]) object;
				
				if (queryResult[0] != null) {
					ClaroInterfaceProcesoEstadistica acmInterfaceProcesoEstadistica = estadisticas.get((Long)queryResult[0]);
					
					Long estado = (Long) queryResult[1];
					
					if (estado.equals(new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.ParaProcesar")))) {
						acmInterfaceProcesoEstadistica.setCantidadRegistrosParaProcesar((Long) queryResult[2]);
					} else if (estado.equals(new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.ParaProcesarPrioritario")))) {
						acmInterfaceProcesoEstadistica.setCantidadRegistrosParaProcesarPrioritario((Long) queryResult[2]);
					} else if (estado.equals(new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.Procesado")))) {
						acmInterfaceProcesoEstadistica.setCantidadRegistrosProcesado((Long) queryResult[2]);
					} else if (estado.equals(new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.EnProceso")))) {
						acmInterfaceProcesoEstadistica.setCantidadRegistrosEnProceso((Long) queryResult[2]);
					} else if (estado.equals(new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.ListaVacia")))) {
						acmInterfaceProcesoEstadistica.setCantidadRegistrosListaVacia((Long) queryResult[2]);
					}
				}
			}
			
			List<ClaroInterfaceProcesoEstadistica> toOrder = new LinkedList<ClaroInterfaceProcesoEstadistica>();
			for (ClaroInterfaceProcesoEstadistica acmInterfaceProcesoEstadistica : estadisticas.values()) {
				toOrder.add(acmInterfaceProcesoEstadistica);
			}
			
			Collections.sort(toOrder);
			
			result = toOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ClaroInterfaceProceso save(ClaroInterfaceProceso acmInterfaceProceso) {
		ClaroInterfaceProceso result = null;
		
		try {
			result = entityManager.merge(acmInterfaceProceso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public void finalizarProcesos() {
		try {
			Query querySinFinalizar = entityManager.createQuery(
				"SELECT DISTINCT m.procesoId"
				+ " FROM ClaroInterfaceNim m"
				+ " WHERE m.procesoId IS NOT NULL"
				+ " AND m.estado.id NOT IN ("
					+ " :estadoIdProcesado, :estadoIdListaVacia, :estadoIdListaNegra"
				+ " )"
			);
			querySinFinalizar.setParameter(
				"estadoIdProcesado", 
				new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.Procesado"))
			);
			querySinFinalizar.setParameter(
				"estadoIdListaVacia", 
				new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.ListaVacia"))
			);
			querySinFinalizar.setParameter(
				"estadoIdListaNegra", 
				new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.ListaNegra"))
			);
			
			Collection<Long> sinFinalizar = new LinkedList<Long>();
			for (Object object : querySinFinalizar.getResultList()) {
				sinFinalizar.add((Long) object);
			}
			
			Query queryNim = entityManager.createQuery(
				"SELECT m.procesoId, max(m.fact)"
				+ " FROM ClaroInterfaceNim m"
				+ " WHERE m.procesoId IS NOT NULL"
				+ " AND m.estado.id IN ("
					+ " :estadoIdProcesado, :estadoIdListaVacia"
				+ " )"
				+ " GROUP BY m.procesoId"
			);
			queryNim.setParameter(
				"estadoIdProcesado", 
				new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.Procesado"))
			);
			queryNim.setParameter(
				"estadoIdListaVacia", 
				new Long(Configuration.getInstance().getProperty("acmInterfaceEstado.ListaVacia"))
			);
			
			for (Object object : queryNim.getResultList()) {
				Object[] queryResult = (Object[]) object;
				
				Long procesoId = (Long) queryResult[0];
				
				if (!sinFinalizar.contains(procesoId)) {
					ClaroInterfaceProceso acmInterfaceProceso = 
						entityManager.find(ClaroInterfaceProceso.class, procesoId);
					
					if (acmInterfaceProceso.getFechaFin() == null) {
						acmInterfaceProceso.setFechaFin((Date)queryResult[1]);
					
						entityManager.merge(acmInterfaceProceso);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}