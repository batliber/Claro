package uy.com.amensg.claro.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.amensg.claro.entities.ClaroInterfaceContrato;
import uy.com.amensg.claro.entities.Empresa;
import uy.com.amensg.claro.entities.MetadataConsulta;
import uy.com.amensg.claro.entities.MetadataConsultaResultado;

@Remote
public interface IClaroInterfaceContratoBean {

	public Collection<ClaroInterfaceContrato> list();
	
	public String preprocesarExportacion(MetadataConsulta metadataConsulta, Empresa empresa);
	
	public String exportarAExcel(MetadataConsulta metadataConsulta, Long loggedUsuarioId);
	
	public String exportarAExcel(MetadataConsulta metadataConsulta, Empresa empresa, String observaciones);
	
	public void reprocesar(MetadataConsulta metadataConsulta, String observaciones);
	
	public MetadataConsultaResultado list(MetadataConsulta metadataConsulta);
}