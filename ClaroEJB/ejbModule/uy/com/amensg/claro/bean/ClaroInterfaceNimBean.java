package uy.com.amensg.claro.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClaroInterfaceNimBean implements IClaroInterfaceNimBean {

	@PersistenceContext(unitName = "uy.com.amensg.claro.persistenceUnit")
	private EntityManager entityManager;
}