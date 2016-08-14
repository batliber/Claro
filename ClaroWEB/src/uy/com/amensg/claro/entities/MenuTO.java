package uy.com.amensg.claro.entities;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class MenuTO extends BaseTO {

	private String titulo;
	private String url;
	private Long orden;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}
}