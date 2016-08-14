package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.Usuario;

@Remote
public interface IUsuarioBean {

	public Collection<Usuario> list();
	
	public Usuario getById(Long id);
	
	public Usuario getByLogin(String login);
	
	public void save(Usuario usuario);
	
	public void remove(Usuario usuario);
	
	public void update(Usuario usuario);
}