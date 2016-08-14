package uy.com.amensg.claro.bean;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uy.com.amensg.claro.entities.ClaroInterfaceEstado;

public class ClaroInterfaceEstadoBean implements IClaroInterfaceEstadoBean {

	@PersistenceContext(unitName = "uy.com.amensg.claro.persistenceUnit")
	private EntityManager entityManager;
	
	public Collection<ClaroInterfaceEstado> list() {
		Collection<ClaroInterfaceEstado> result = new LinkedList<ClaroInterfaceEstado>();
		
		try {
			TypedQuery<ClaroInterfaceEstado> query = entityManager.createQuery(
				"SELECT e"
				+ " FROM ClaroInterfaceEstado e"
				+ " ORDER BY e.id", 
				ClaroInterfaceEstado.class
			);
			
			for (ClaroInterfaceEstado estado : query.getResultList()) {
				result.add(estado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}