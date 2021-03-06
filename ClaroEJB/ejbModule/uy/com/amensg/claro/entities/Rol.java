package uy.com.amensg.claro.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seguridad_rol")
public class Rol extends BaseEntity {

	private static final long serialVersionUID = -1221155230957677526L;

	@Column(name = "nombre")
	private String nombre;

	@ManyToMany
	@JoinTable(name = "seguridad_menu_rol", 
		joinColumns=@JoinColumn(name = "seguridad_rol_id"),
		inverseJoinColumns=@JoinColumn(name = "seguridad_menu_id")
	)
	private Collection<Menu> menus;
	
	@OneToMany
	@JoinTable(name = "seguridad_rol_jerarquia", 
		joinColumns=@JoinColumn(name = "rol_id"),
		inverseJoinColumns=@JoinColumn(name = "rol_subordinado_id")
	)
	private Collection<Rol> subordinados;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}

	public Collection<Rol> getSubordinados() {
		return subordinados;
	}
	
	public void setSubordinados(Collection<Rol> subordinados) {
		this.subordinados = subordinados;
	}
}