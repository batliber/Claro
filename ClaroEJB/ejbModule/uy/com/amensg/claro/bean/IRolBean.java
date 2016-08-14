package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.Rol;

@Remote
public interface IRolBean {

	public Collection<Rol> list();
	
	public Rol getById(Long id);
}