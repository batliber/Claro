package uy.com.amensg.claro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa extends BaseEntity {

	private static final long serialVersionUID = -4633009571599583406L;
	
	@Column(name = "nombre")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}