package uy.com.amensg.claro.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "claro_interface_nim")
public class ClaroInterfaceNim implements Serializable {

	private static final long serialVersionUID = 1359799213786819911L;

	@Id
	@Column(name = "nim")
	private Long nim;

	@Column(name = "proceso_id")
	private Long procesoId;

	@Column(name = "uact")
	private Long uact;

	@Column(name = "fact")
	private Date fact;

	@Column(name = "term")
	private Long term;

	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@JoinColumn(name = "estado", nullable = true)
	private ClaroInterfaceEstado estado;
	
	public Long getNim() {
		return nim;
	}

	public void setNim(Long nim) {
		this.nim = nim;
	}

	public Long getProcesoId() {
		return procesoId;
	}

	public void setProcesoId(Long procesoId) {
		this.procesoId = procesoId;
	}

	public Long getUact() {
		return uact;
	}

	public void setUact(Long uact) {
		this.uact = uact;
	}

	public Date getFact() {
		return fact;
	}

	public void setFact(Date fact) {
		this.fact = fact;
	}

	public Long getTerm() {
		return term;
	}

	public void setTerm(Long term) {
		this.term = term;
	}

	public ClaroInterfaceEstado getEstado() {
		return estado;
	}

	public void setEstado(ClaroInterfaceEstado estado) {
		this.estado = estado;
	}
}