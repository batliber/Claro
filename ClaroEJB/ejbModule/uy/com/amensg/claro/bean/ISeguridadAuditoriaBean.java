package uy.com.amensg.claro.bean;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.SeguridadAuditoria;

@Remote
public interface ISeguridadAuditoriaBean {

	public void save(SeguridadAuditoria seguridadAuditoria);
}