<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Claro</title>
	<script type="text/javascript" src="/ClaroWEB/dwr/engine.js"></script>
	<script type="text/javascript" src="/ClaroWEB/dwr/util.js"></script>
	<script type="text/javascript" src="/ClaroWEB/dwr/interface/SeguridadDWR.js"></script>
	<script type="text/javascript" src="/ClaroWEB/dwr/interface/ClaroInterfaceContratoDWR.js"></script>
	<script type="text/javascript" src="/ClaroWEB/dwr/interface/UsuarioRolEmpresaDWR.js"></script>
	<script type="text/javascript" src="/ClaroWEB/dwr/interface/ClaroInterfaceEstadoDWR.js"></script>
	<script type="text/javascript" src="/ClaroWEB/dwr/interface/UsuarioDWR.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/jquery-ui.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/util.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/global.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/menu.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/filtros_dinamicos.js"></script>
	<script type="text/javascript" src="/ClaroWEB/js/grid.js"></script>
	<script type="text/javascript" src="/ClaroWEB/pages/claro/claro.js"></script>
	<link rel="stylesheet" type="text/css" href="/ClaroWEB/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="/ClaroWEB/css/menu.css"/>
	<link rel="stylesheet" type="text/css" href="/ClaroWEB/css/filtros_dinamicos.css"/>
	<link rel="stylesheet" type="text/css" href="/ClaroWEB/css/grid.css"/>
	<link rel="stylesheet" type="text/css" href="/ClaroWEB/pages/claro/claro.css"/>
</head>
<body>
	<div class="divMenuBar">
<%@ include file="/includes/menu.jsp" %>
	</div>
	<div class="divButtonBar">
		<div class="divButton"><input type="submit" id="inputActualizar" value="Actualizar" onclick="javascript:inputActualizarOnClick(event, this)"/></div>
		<div class="divButton" id="divButtonExportarAExcel">
			<form method="post" id="formExportarAExcel" action="#"><input type="submit" id="inputExportarAExcel" value="Exporta a Excel" onclick="javascript:inputExportarAExcelOnClick(event, this)"/></form>
		</div>
		<div class="divButtonBarSeparator">&nbsp;</div>
	</div>
	<div class="divButtonTitleBar">
		<div id="divButtonTitleSingleSize" class="divButtonTitleBarTitle">Acciones</div>
		<div class="divButtonTitleBarSeparator">&nbsp;</div>
	</div>
	<div class="divMainWindow">
		<div id="divFiltros">
			<div class="divFormLabelExtended">Tama&ntilde;o de muestra:</div>
			<div id="divTamanoMuestra"><input type="text" id="inputTamanoMuestra" value="50" onchange="javascript:grid.filtroDinamico.tamanoMuestraOnChange(event)"/></div>
			<div class="divFormLabelExtended">Tama&ntilde;o subconjunto:</div>
			<div id="divTamanoSubconjunto"><input type="text" id="inputTamanoSubconjunto" value="1" onchange="javascript:grid.filtroDinamico.tamanoSubconjuntoOnChange(event)"/></div>
			<div id="divAgregarFiltroContainer">
				<div class="divFormLabelExtended">Agregar filtro:</div>
				<div id="divAgregarFiltro"><input type="submit" value="Agregar" id="inputAgregarFiltro" onclick="javascript:grid.filtroDinamico.agregarFiltro(event, this)"/></div>
				<div class="divFormLabelExtended">Limpiar filtros:</div>
				<div id="divLimpiarFiltros"><input type="submit" value="Limpiar" id="inputLimpiarFiltros" onclick="javascript:grid.filtroDinamico.limpiarFiltros(event, this)"/></div>
			</div>
		</div>
		<div id="divContratos">
			<div id="divTableContratos">&nbsp;</div>
		</div>
	</div>
	<div id="divModalBackgroundChild">&nbsp;</div>
</body>
</html>