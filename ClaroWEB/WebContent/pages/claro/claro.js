var __ROL_ADMINISTRADOR = 1;

var grid = null;

$(document).ready(function() {
	$("#divButtonAsignar").hide();
	$("#divButtonSubirArchivo").hide();
	$("#divButtonAgregarMid").hide();
	$("#divButtonExportarAExcel").hide();
	
	SeguridadDWR.getActiveUserData(
		{
			callback: function(data) {
				for (var i=0; i<data.usuarioRolEmpresas.length; i++) {
					if (data.usuarioRolEmpresas[i].rol.id == __ROL_ADMINISTRADOR){
						$("#divButtonAsignar").show();
						$("#divButtonSubirArchivo").show();
						$("#divButtonAgregarMid").show();
						$("#divButtonExportarAExcel").show();
						
						grid = new Grid(
							document.getElementById("divTableContratos"),
							{
								tdNim: { campo: "nim", descripcion: "Nim", abreviacion: "Nim", tipo: __TIPO_CAMPO_NUMERICO, ancho: 60 },
								tdSimCard: { campo: "simCard", descripcion: "SIM card", abreviacion: "SIM", tipo: __TIPO_CAMPO_STRING, ancho: 60 },
								tdTipo: { campo: "tipo", descripcion: "Tipo", abreviacion: "Tipo", tipo: __TIPO_CAMPO_STRING, ancho: 60 },
								tdIccid: { campo: "iccid", descripcion: "ICCID", abreviacion: "ICCID", tipo: __TIPO_CAMPO_STRING, ancho: 120 },
								tdImsi: { campo: "imsi", descripcion: "IMSI", abreviacion: "IMSI", tipo: __TIPO_CAMPO_STRING, ancho: 100 },
								tdEstadoContrato: { campo: "estadoContrato", descripcion: "Estado", abreviacion: "Estado", tipo: __TIPO_CAMPO_STRING, ancho: 60 },
								tdDescEstadoContrato: { campo: "descEstadoContrato", descripcion: "Descripción estado", abreviacion: "Desc. Estado", tipo: __TIPO_CAMPO_STRING },
								tdFormaVenta: { campo: "formaVenta", descripcion: "Forma de venta", abreviacion: "Forma venta", tipo: __TIPO_CAMPO_STRING, ancho: 90 },
								tdDuenio: { campo: "duenio", descripcion: "Dueño", abreviacion: "Dueño", tipo: __TIPO_CAMPO_STRING },
								tdAgente: { campo: "agente", descripcion: "Agente", abreviacion: "Agente", tipo: __TIPO_CAMPO_STRING },
								tdModo: { campo: "modo", descripcion: "Modo", abreviacion: "Modo", tipo: __TIPO_CAMPO_STRING, ancho: 60 },
								tdVigenciaDesde:  { campo: "vigenciaDesde", descripcion: "Vigencia desde", abreviacion: "Vigencia desde", tipo: __TIPO_CAMPO_FECHA, ancho: 100 },
								tdTerminal: { campo: "terminal", descripcion: "Terminal", abreviacion: "Terminal", tipo: __TIPO_CAMPO_STRING, ancho: 80 },
								tdDescTerminal: { campo: "descTerminal", descripcion: "Descripción terminal", abreviacion: "Desc. Terminal", tipo: __TIPO_CAMPO_STRING },
								tdImei: { campo: "imei", descripcion: "IMEI", abreviacion: "IMEI", tipo: __TIPO_CAMPO_STRING },
								tdEstadoContrato2: { campo: "estadoContrato2", descripcion: "Estado 2", abreviacion: "Estado 2", tipo: __TIPO_CAMPO_STRING, ancho: 65 },
								tdDescEstadoContrato2: { campo: "descEstadoContrato2", descripcion: "Descripción estado 2", abreviacion: "Desc. Estado 2", tipo: __TIPO_CAMPO_STRING },
								tdFVenta: { campo: "fVenta", descripcion: "Fecha de venta", abreviacion: "Fecha venta", tipo: __TIPO_CAMPO_FECHA, ancho: 85 },
								tdAgente2: { campo: "agente2", descripcion: "Agente 2", abreviacion: "Agente 2", tipo: __TIPO_CAMPO_STRING },
								tdCuentaRemanente: { campo: "cuentaRemanente", descripcion: "Cuenta remanente", abreviacion: "Cuenta reman.", tipo: __TIPO_CAMPO_STRING, ancho: 100 },
								tdFechaCreacionRemanente: { campo: "fechaCreacionRemanente", descripcion: "Fecha de creación rem.", abreviacion: "Fecha creac. rem.", tipo: __TIPO_CAMPO_FECHA, ancho: 100 },
								tdMontoSubsidiario: { campo: "montoSubsidiario", descripcion: "Monto subsidiario", abreviacion: "Monto subs.", tipo: __TIPO_CAMPO_STRING, ancho: 85 },
								tdProductoRemanente: { campo: "productoRemanente", descripcion: "Producto remanente", abreviacion: "Producto reman.", tipo: __TIPO_CAMPO_STRING },
								tdDescProductoRemanente: { campo: "descProductoRemanente", descripcion: "Descripción producto rem.", abreviacion: "Desc. prod. reman.", tipo: __TIPO_CAMPO_STRING, ancho: 120 },
								tdImeiRemanente: { campo: "imeiRemanente", descripcion: "IMEI remanente", abreviacion: "IMEI reman.", tipo: __TIPO_CAMPO_STRING },
								tdEstadoRemanente: { campo: "estadoRemanente", descripcion: "Estado remanente", abreviacion: "Estado reman.", tipo: __TIPO_CAMPO_STRING },
								tdNumeralIsrRemanente: { campo: "numeralIsrRemanente", descripcion: "Numeral ISR remanente", abreviacion: "Numeral ISR rem.", tipo: __TIPO_CAMPO_STRING },
								tdNumeralActivoRemanente: { campo: "numeralActivoRemanente", descripcion: "Numeral activo rem.", abreviacion: "Numeral activo rem.", tipo: __TIPO_CAMPO_STRING },
								tdNumeralCarterRemanente: { campo: "numeralCarterRemanente", descripcion: "Numeral Carter rem.", abreviacion: "Numeral Carter rem.", tipo: __TIPO_CAMPO_STRING },
								tdAcreditableRemanente: { campo: "acreditableRemanente", descripcion: "Acreditable remanente", abreviacion: "Acreditable reman.", tipo: __TIPO_CAMPO_STRING },
								tdEstadoGeneral: { campo: "estadoGeneral", descripcion: "Estado general", abreviacion: "Estado gral.", tipo: __TIPO_CAMPO_STRING },
								tdVigenciaDesde2: { campo: "vigenciaDesde2", descripcion: "Vigencia desde 2", abreviacion: "Vigencia desde 2", tipo: __TIPO_CAMPO_FECHA, ancho: 100 },
								tdFact: { campo: "fact", descripcion: "Obtenido", abreviacion: "Obtenido", tipo: __TIPO_CAMPO_FECHA },
							}, 
							reloadData,
							trContratoOnClick
						);
						
						grid.rebuild();
						
						break;
					}
				}
				
				if (grid == null) {
					grid = new Grid(
						document.getElementById("divTableContratos"),
						{
							tdNim: { campo: "nim", descripcion: "Nim", abreviacion: "Nim", tipo: __TIPO_CAMPO_NUMERICO },
							tdFact: { campo: "fact", descripcion: "Obtenido", abreviacion: "Obtenido", tipo: __TIPO_CAMPO_FECHA },
						}, 
						reloadData,
						trContratoOnClick
					);
					
					grid.rebuild();
				}
			}, async: false
		}
	);
	
	reloadData();
});

function reloadData() {
	grid.setStatus(grid.__STATUS_LOADING);
	
	ClaroInterfaceContratoDWR.list(
		grid.filtroDinamico.calcularMetadataConsulta(),
		{
			callback: function(data) {
				grid.reload(data);
			}
		}
	);
}

function inputActualizarOnClick(event, element) {
	reloadData();
}

function trContratoOnClick(eventObject) {
	
}

function inputExportarAExcelOnClick(event, element) {
	ClaroInterfaceContratoDWR.exportarAExcel(
		grid.filtroDinamico.calcularMetadataConsulta(),
		{
			callback: function(data) {
				document.getElementById("formExportarAExcel").action = "/ClaroWEB/Download?fn=" + data;
				document.getElementById("formExportarAExcel").submit();
			}, async: false
		}
	);
}