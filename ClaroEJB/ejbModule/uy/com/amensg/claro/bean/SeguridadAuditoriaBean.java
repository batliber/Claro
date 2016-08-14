package uy.com.amensg.claro.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.amensg.claro.entities.SeguridadAuditoria;

@Stateless
public class SeguridadAuditoriaBean implements ISeguridadAuditoriaBean {

	@PersistenceContext(unitName = "uy.com.amensg.claro.persistenceUnit")
	private EntityManager entityManager;
	
	public void save(SeguridadAuditoria seguridadAuditoria) {
		try {
			entityManager.persist(seguridadAuditoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}