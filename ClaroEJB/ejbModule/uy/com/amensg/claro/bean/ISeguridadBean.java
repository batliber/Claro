package uy.com.amensg.claro.bean;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.SeguridadAuditoria;

@Remote
public interface ISeguridadBean {

	public SeguridadAuditoria login(String login, String contrsena);
	
	public void logout(Long usuarioId);

	public void sessionTimeout(Long usuarioId);
}