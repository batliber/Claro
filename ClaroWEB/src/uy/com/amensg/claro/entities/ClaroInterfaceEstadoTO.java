package uy.com.amensg.claro.entities;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class ClaroInterfaceEstadoTO extends BaseTO {

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}