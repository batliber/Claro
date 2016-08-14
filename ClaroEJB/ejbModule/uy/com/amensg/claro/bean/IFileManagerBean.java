package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.Archivo;

@Remote
public interface IFileManagerBean {

	public Collection<Archivo> listArchivos();
}