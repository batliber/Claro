package uy.com.amensg.claro.entities;

import java.io.Serializable;
import java.util.Date;

public class ClaroInterfaceProcesoEstadistica implements Serializable, Comparable<ClaroInterfaceProcesoEstadistica> {

	private static final long serialVersionUID = 2678407438024316532L;
	
	private Long id;
	private Date fechaInicio;
	private Date fechaFin;
	private String observaciones;
	private Long cantidadRegistrosParaProcesar;
	private Long cantidadRegistrosParaProcesarPrioritario;
	private Long cantidadRegistrosProcesado;
	private Long cantidadRegistrosEnProceso;
	private Long cantidadRegistrosListaVacia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getCantidadRegistrosParaProcesar() {
		return cantidadRegistrosParaProcesar;
	}

	public void setCantidadRegistrosParaProcesar(
			Long cantidadRegistrosParaProcesar) {
		this.cantidadRegistrosParaProcesar = cantidadRegistrosParaProcesar;
	}

	public Long getCantidadRegistrosParaProcesarPrioritario() {
		return cantidadRegistrosParaProcesarPrioritario;
	}

	public void setCantidadRegistrosParaProcesarPrioritario(
			Long cantidadRegistrosParaProcesarPrioritario) {
		this.cantidadRegistrosParaProcesarPrioritario = cantidadRegistrosParaProcesarPrioritario;
	}

	public Long getCantidadRegistrosProcesado() {
		return cantidadRegistrosProcesado;
	}

	public void setCantidadRegistrosProcesado(Long cantidadRegistrosProcesado) {
		this.cantidadRegistrosProcesado = cantidadRegistrosProcesado;
	}

	public Long getCantidadRegistrosEnProceso() {
		return cantidadRegistrosEnProceso;
	}

	public void setCantidadRegistrosEnProceso(Long cantidadRegistrosEnProceso) {
		this.cantidadRegistrosEnProceso = cantidadRegistrosEnProceso;
	}

	public Long getCantidadRegistrosListaVacia() {
		return cantidadRegistrosListaVacia;
	}

	public void setCantidadRegistrosListaVacia(Long cantidadRegistrosListaVacia) {
		this.cantidadRegistrosListaVacia = cantidadRegistrosListaVacia;
	}

	public int compareTo(ClaroInterfaceProcesoEstadistica o) {
		return -this.getFechaInicio().compareTo(o.fechaInicio);
	}
}