package uy.com.amensg.claro.entities;

import java.util.Collection;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class MetadataConsultaResultadoTO {

	private Long cantidadRegistros;
	private Collection<Object> registrosMuestra;

	public Long getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(Long cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public Collection<Object> getRegistrosMuestra() {
		return registrosMuestra;
	}

	public void setRegistrosMuestra(Collection<Object> registrosMuestra) {
		this.registrosMuestra = registrosMuestra;
	}
}