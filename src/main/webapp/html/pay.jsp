<!DOCTYPE html>
<%@page import="pe.unjfsc.daw.controller.Util"%>
<%@page import="pe.unjfsc.daw.model.impl.CDTramite"%>
<%@page import="pe.unjfsc.daw.model.impl.CITramite"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="pe.unjfsc.daw.entity.CERecibo"%>
<%@page import="pe.unjfsc.daw.entity.CEUsuario"%>
<%@page import="pe.unjfsc.daw.entity.CETramite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>
<%
CERecibo oReci = (CERecibo) session.getAttribute("reciboPago");
CITramite oCIT = new CDTramite();
CETramite otram = oCIT.buscarTramiteByCod(oReci.getCod_tramite());
CEUsuario oUser = (CEUsuario) session.getAttribute("userSession");
if (oUser == null || oReci == null || otram == null) {
	response.sendRedirect("../");
} else {
%>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fausti Pay</title>
<link rel="icon" href="../img/ico/logo-unjfsc-ico.ico">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500;700;800&family=Poppins:wght@300&family=Varela+Round&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="../css/styles.css" rel="stylesheet">
<link href="../css/pay/style.css" rel="stylesheet">
<link href="../css/pay/style_recibo.css" rel="stylesheet">
</head>
<body>
<!--  
	<header>
		<div id="div-header-logo" class="d">
			<img class="evt-hover" src="../img/principal/Logo.svg" alt=""
				height="70px">
		</div>
		<div id="div-header-options" class="d">
			<a href="./principal.jsp" class="evt-hover"> <img
				src="../img/pay/add.svg" alt="" height="20px"
				style="padding-right: 5px;"> Nuevo pago
			</a> <a href="" class="button-23" role="button"
				title="Opciones de usuario"> <img
				src="../img/principal/user.png" alt=""
				style="border-radius: 50%; height: 28px;"> &nbsp;&nbsp;<%
 //out.print(oUser.getNom_usuario());
 %>&nbsp;&nbsp;<img src="../img/principal/downarrow.svg" alt=""
				style="border-radius: 50%; height: 16px;">
			</a>
		</div>
	</header>
	-->
	<br><br><br>
	<section style="display:flex; justify-content:center; align-items:center; width:100%; height:140vh;">
		<div class="container">
			<div class="logo_uni">
				<img src="../img/svg/Logo_fautino.svg" alt="">
			</div>
			<div class="logo">
				<img class="logo_faustipay" src="../img/pay/Logo.svg" alt="">
			</div>
			<div class="title_text">
				<p class="title_01">UNIVERSIDAD NACIONAL</p>
				<p class="title_02">JOSE FAUSTINO SANCHEZ CARRION</p>
				<p class="title_03">R.U.C N° 20172299742</p>
				<p class="title_04">RECIBO DE INGRESO</p>
				<h4 class="datos_personales">Datos personales</h4>
				<div class="num">
					<h4 class="n">N°</h4>
					<label> <%
 out.print(oReci.getNum_recibo());
 %>
					</label>
				</div>
				<div class="datos">
					<label>APELLIDOS Y NOMBRE: </label> <label class="text_datos">
						<%
						out.print(oUser.getApe_usuario() + " " + oUser.getNom_usuario());
						%>
					</label><br> <label>DNI: </label> <label class="text_dni">
						<%
						out.print(oUser.getDni_usuario());
						%>
					</label>
				</div>
				<h4 class="title_05">Datos de la operacion</h4>
				<div class="escuela">
					<label for="#">ESCUELA- PROYECTO Y/O OTROS: </label> <label
						class="label_e" for="#"> <%
 out.print(otram.getESCU_TRAMITE());
 %>
					</label>
				</div>
			</div>
			<br>
			<div class="container_table">
				<table class="table_cod">
					<thead>
						<tr>
							<th>CODIGO</th>
							<th>CONCEPTO</th>
							<th>IMPORTE</th>
						</tr>
					</thead>
					<tbody>
						<tr class="espacio">
							<th></th>
						</tr>
						<tr class="tr">
							<td>
								<%
								out.print(Util.newCodigo(otram.getCODI_TRAMITE()));
								%>
							</td>
							<td>
								<%
								out.print(otram.getNOMB_TRAMITE());
								%>
							</td>
							<td>
								<%
								out.print("S/. " + otram.getMONT_TRAMITE());
								%>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="total">
					<label for="#">Total: <%
					out.print("S/. " + otram.getMONT_TRAMITE());
					%></label>
				</div>
				<div class="cod_qr">
					<img src="../img/pay/Rectangle 51.png" alt="#">
				</div>
			</div>
		</div>
	</section>
</body>
</html>
<%
}
%>