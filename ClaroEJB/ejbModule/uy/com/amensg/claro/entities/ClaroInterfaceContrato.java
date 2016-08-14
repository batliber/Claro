package uy.com.amensg.claro.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claro_interface_contrato")
public class ClaroInterfaceContrato implements Serializable {

	private static final long serialVersionUID = -1894849400288838704L;

	@Id
	@Column(name = "nim")
	private Long nim;
	
	@Column(name = "sim_card")
	private String simCard;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "iccid")
	private String iccid;
	
	@Column(name = "imsi")
	private String imsi;
	
	@Column(name = "estado_contrato")
	private String estadoContrato;
	
	@Column(name = "desc_estado_contrato")
	private String descEstadoContrato;
	
	@Column(name = "forma_venta")
	private String formaVenta;
	
	@Column(name = "duenio")
	private String duenio;
	
	@Column(name = "agente")
	private String agente;
	
	@Column(name = "modo")
	private String modo;
	
	@Column(name = "vigencia_desde")
	private Date vigenciaDesde;
	
	@Column(name = "terminal")
	private String terminal;
	
	@Column(name = "desc_terminal")
	private String descTerminal;
	
	@Column(name = "imei")
	private String imei;
	
	@Column(name = "estado_contrato_2")
	private String estadoContrato2;
	
	@Column(name = "desc_estado_contrato_2")
	private String descEstadoContrato2;
	
	@Column(name = "fventa")
	private Date fVenta;
	
	@Column(name = "agente_2")
	private String agente2;
	
	@Column(name = "cuenta_remanente")
	private String cuentaRemanente;
	
	@Column(name = "fecha_creacion_remanente")
	private Date fechaCreacionRemanente;
	
	@Column(name = "monto_subsidiado")
	private String montoSubsidiario;
	
	@Column(name = "producto_remanente")
	private String productoRemanente;
	
	@Column(name = "desc_producto_remanente")
	private String descProductoRemanente;
	
	@Column(name = "imei_remanente")
	private String imeiRemanente;
	
	@Column(name = "estado_remanente")
	private String estadoRemanente;
	
	@Column(name = "numeral_isr_remanente")
	private String numeralIsrRemanente;
	
	@Column(name = "numeral_activo_remanente")
	private String numeralActivoRemanente;
	
	@Column(name = "numeral_carter_remanente")
	private String numeralCarterRemanente;
	
	@Column(name = "acreditable_remanente")
	private String acreditableRemanente;
	
	@Column(name = "estado_general")
	private String estadoGeneral;
	
	@Column(name = "vigencia_desde2")
	private Date vigenciaDesde2;

	@Column(name = "uact")
	private Long uact;

	@Column(name = "fact")
	private Date fact;

	@Column(name = "term")
	private Long term;
	
	public Long getNim() {
		return nim;
	}

	public void setNim(Long nim) {
		this.nim = nim;
	}

	public String getSimCard() {
		return simCard;
	}

	public void setSimCard(String simCard) {
		this.simCard = simCard;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getEstadoContrato() {
		return estadoContrato;
	}

	public void setEstadoContrato(String estadoContrato) {
		this.estadoContrato = estadoContrato;
	}

	public String getDescEstadoContrato() {
		return descEstadoContrato;
	}

	public void setDescEstadoContrato(String descEstadoContrato) {
		this.descEstadoContrato = descEstadoContrato;
	}

	public String getFormaVenta() {
		return formaVenta;
	}

	public void setFormaVenta(String formaVenta) {
		this.formaVenta = formaVenta;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public Date getVigenciaDesde() {
		return vigenciaDesde;
	}

	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getDescTerminal() {
		return descTerminal;
	}

	public void setDescTerminal(String descTerminal) {
		this.descTerminal = descTerminal;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getEstadoContrato2() {
		return estadoContrato2;
	}

	public void setEstadoContrato2(String estadoContrato2) {
		this.estadoContrato2 = estadoContrato2;
	}

	public String getDescEstadoContrato2() {
		return descEstadoContrato2;
	}

	public void setDescEstadoContrato2(String descEstadoContrato2) {
		this.descEstadoContrato2 = descEstadoContrato2;
	}

	public Date getfVenta() {
		return fVenta;
	}

	public void setfVenta(Date fVenta) {
		this.fVenta = fVenta;
	}

	public String getAgente2() {
		return agente2;
	}

	public void setAgente2(String agente2) {
		this.agente2 = agente2;
	}

	public String getCuentaRemanente() {
		return cuentaRemanente;
	}

	public void setCuentaRemanente(String cuentaRemanente) {
		this.cuentaRemanente = cuentaRemanente;
	}

	public Date getFechaCreacionRemanente() {
		return fechaCreacionRemanente;
	}

	public void setFechaCreacionRemanente(Date fechaCreacionRemanente) {
		this.fechaCreacionRemanente = fechaCreacionRemanente;
	}

	public String getMontoSubsidiario() {
		return montoSubsidiario;
	}

	public void setMontoSubsidiario(String montoSubsidiario) {
		this.montoSubsidiario = montoSubsidiario;
	}

	public String getProductoRemanente() {
		return productoRemanente;
	}

	public void setProductoRemanente(String productoRemanente) {
		this.productoRemanente = productoRemanente;
	}

	public String getDescProductoRemanente() {
		return descProductoRemanente;
	}

	public void setDescProductoRemanente(String descProductoRemanente) {
		this.descProductoRemanente = descProductoRemanente;
	}

	public String getImeiRemanente() {
		return imeiRemanente;
	}

	public void setImeiRemanente(String imeiRemanente) {
		this.imeiRemanente = imeiRemanente;
	}

	public String getEstadoRemanente() {
		return estadoRemanente;
	}

	public void setEstadoRemanente(String estadoRemanente) {
		this.estadoRemanente = estadoRemanente;
	}

	public String getNumeralIsrRemanente() {
		return numeralIsrRemanente;
	}

	public void setNumeralIsrRemanente(String numeralIsrRemanente) {
		this.numeralIsrRemanente = numeralIsrRemanente;
	}

	public String getNumeralActivoRemanente() {
		return numeralActivoRemanente;
	}

	public void setNumeralActivoRemanente(String numeralActivoRemanente) {
		this.numeralActivoRemanente = numeralActivoRemanente;
	}

	public String getNumeralCarterRemanente() {
		return numeralCarterRemanente;
	}

	public void setNumeralCarterRemanente(String numeralCarterRemanente) {
		this.numeralCarterRemanente = numeralCarterRemanente;
	}

	public String getAcreditableRemanente() {
		return acreditableRemanente;
	}

	public void setAcreditableRemanente(String acreditableRemanente) {
		this.acreditableRemanente = acreditableRemanente;
	}

	public String getEstadoGeneral() {
		return estadoGeneral;
	}

	public void setEstadoGeneral(String estadoGeneral) {
		this.estadoGeneral = estadoGeneral;
	}

	public Date getVigenciaDesde2() {
		return vigenciaDesde2;
	}

	public void setVigenciaDesde2(Date vigenciaDesde2) {
		this.vigenciaDesde2 = vigenciaDesde2;
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
}