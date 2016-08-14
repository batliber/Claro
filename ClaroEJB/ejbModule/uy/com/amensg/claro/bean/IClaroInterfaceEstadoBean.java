package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.ClaroInterfaceEstado;

@Remote
public interface IClaroInterfaceEstadoBean {

	public Collection<ClaroInterfaceEstado> list();
}