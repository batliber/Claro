package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.Usuario;
import uy.com.amensg.claro.entities.UsuarioRolEmpresa;

@Remote
public interface IUsuarioRolEmpresaBean {
	
	public Collection<UsuarioRolEmpresa> listByUsuario(Usuario usuario);
}