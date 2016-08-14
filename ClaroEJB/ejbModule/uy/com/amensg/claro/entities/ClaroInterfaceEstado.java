package uy.com.amensg.claro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "claro_interface_estado")
public class ClaroInterfaceEstado extends BaseEntity {

	private static final long serialVersionUID = 454019230326269133L;
	
	@Column(name = "descripcion")
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}