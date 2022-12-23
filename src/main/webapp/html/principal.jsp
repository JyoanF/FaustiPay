<!DOCTYPE html>

<%@page import="pe.unjfsc.daw.entity.CETramite"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="pe.unjfsc.daw.model.impl.CITramite"%>
<%@page import="pe.unjfsc.daw.model.impl.CDTramite"%>
<%@page import="pe.unjfsc.daw.entity.CEUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>
<%
LinkedHashSet<CETramite> moListTram=new LinkedHashSet<CETramite>();
CITramite oCItram=new CDTramite();
CEUsuario user = (CEUsuario) session.getAttribute("userSession");
if(user==null){
	response.sendRedirect("../");
}else{
%>

<html lang="es">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fausti Pay</title>
<link rel="icon" href="../img/ico/fp.ico">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500;700;800&family=Poppins:wght@300&family=Varela+Round&display=swap"
	rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="../css/styles.css" rel="stylesheet">
</head>

<body>
	<header>
		<div id="div-header-logo" class="d">
			<img class="evt-hover" src="../img/principal/Logo.svg"
				alt="" height="70px">
		</div>
		<div id="div-header-options" class="d">
		<co:url value="./MisRecibos.jsp" var="recibosUrl" />
			<a href="${recibosUrl}"> <img
				src="../img/svg/docs.svg" alt="" height="30px"
				style="padding-right: 5px;" > Mis recibos
			</a> 
			<a style="cursor:pointer;" id="closeSession"> <img
				src="../img/svg/back-arrow.svg" alt="" height="30px"
				style="padding-right: 5px;" > Cerrar Sesion
			</a> 
			<a href="" class="button-23" role="button"
				title="Opciones de usuario"> <img
				src="../img/principal/user.png" alt=""
				style="border-radius: 50%; height: 28px;"> &nbsp;&nbsp;<%out.print(user.getNom_usuario());%>
			</a>
		</div>
	</header>
	<section class="">
		<div id="section-header">
			<h1>
				Hola <span style="color: #007094;"><%out.print(user.getNom_usuario());%></span> ¿Qué pago deseas
				realizar?
			</h1>
		</div>
		<div class="">
			<div>
				<div class="pd-left-10 step-card">
					<div class="number">
						<span>1</span>
					</div>
					&nbsp;&nbsp;Selecciona el tipo de trámite
				</div>
				<div id="tram-type-container">
					<div class="" id="tram-types-cont">
						<div class="tram-type-card">
							<div class="tram-content-card">
								<div class="tram-tittle-card">
									<span><strong>PREGRADO</strong></span>
								</div>
								<img
									src="https://www.uarm.edu.pe/wp-content/uploads/2022/04/estudiantes-pregrado2022.png"
									alt="" width="150px" height="120px"> <button
									class="button-23 btnTipo1" name="PREGRADO">Seleccionar</button>
							</div>
						</div>
						<div class="tram-type-card">
							<div class="tram-content-card">
								<div class="tram-tittle-card">
									<span><strong>POSGRADO</strong></span>
								</div>
								<img
									src="https://i0.wp.com/educacionalfuturo.com/wp-content/uploads/2018/11/FOTO_36857751_xl-2015-1-1-compressed-2.jpg?resize=1024%2C683&ssl=1"
									alt="" width="150px" height="120px"> <button
									class="button-23 btnTipo2" name="POSGRADO">Seleccionar</button>
							</div>
						</div>
						<div class="tram-type-card">
							<div class="tram-content-card">
								<div class="tram-tittle-card">
									<span><strong>OTROS</strong></span>
								</div>
								<img
									src="https://colombia.unir.net/wp-content/uploads/sites/4/2021/06/student-studying-with-a-group-of-friends-online-outdoors-picture-id691703598.jpg"
									alt="" width="150px" height="120px"> <button
									class="button-23 btnTipo3" name="OTROS">Seleccionar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="pd-left-10 step-card">
					<div class="number">
						<span>2</span>
					</div>
					&nbsp;&nbsp;Agrega a tu carrito los trámites que buscas.
				</div>
				<div id="cont-filters-search">
					<div class="filters-search">
						<p>Facultad:&nbsp;</p>
						<select name="" id="cmbFacultades" style="width: 300px; height: 40px;">
						</select>
					</div>
					<div class="filters-search">
						<p>Escuela:&nbsp;</p>
						<select name="" id="cmbEscuelas" style="width: 300px; height: 40px;">
						</select>
					</div>
					<div id="cont-search">
						<div id="text-input-search">
							<img src="../img/principal/lupa.svg" alt="" height="16px">
							&nbsp;Buscar:
						</div>
						<input type="text" name="" id="input-search" autocomplete="false"
							placeholder="Código de trámite" maxlength="3">
					</div>
				</div>
				<div
					style="width: 100%; padding: 30px 0px; display: flex; justify-content: center;">
					<table>
						<thead>
							<tr>
								<th style="width: 40vw;" id="th-name-tram">NOMBRE</th>
								<th style="width: 30vw;" id="th-escuela-tram">ESCUELA</th>
								<th style="width: 10vw;">MONTO</th>
								<th style="width: 10vw;">OPCIÓN</th>
							</tr>
						</thead>
						<tbody id="tableContent">
							
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</section>
	<footer
		style="background-color: #414339; width: 100%; text-align: center; color: #FFFFFF; padding: 30px 0px; font-size: 14px;">
		<a href="https://unjfsc.edu.pe" style="color: #FFFFFF;">Universidad
			Nacional José Faustino Sánchez Carrion</a>
		<p>Copyright © 2022</p>
	</footer>
<script type="text/javascript">
    	$(document).ready(function(){
    		let cmbFac = $("#cmbFacultades");
    		let cmbEsc = $("#cmbEscuelas");
    		var tipoTram;
    		$(".btnTipo1").click(function(event){	
    			tipoTram = $(".btnTipo1").attr("name");
    			llenarCMB(tipoTram);
    		});
    		$(".btnTipo2").click(function(event){	
    			tipoTram = $(".btnTipo2").attr("name");
    			llenarCMB(tipoTram);
    		});
    		$(".btnTipo3").click(function(event){	
    			tipoTram = $(".btnTipo3").attr("name");
    			llenarCMB(tipoTram);
    		});
    		function llenarCMB(data){
    			$.get("../CSPrincipal",{
    				request : "byType",
    				data : data,
    			    contenType : "application/text"
    			}, function(response){
    				let obj=JSON.parse(response);
    				cmbFac.empty();
    				cmbEsc.empty();
    				cmbFac.append($("<option>",{
						value:"Seleccione...",
						text:"Seleccione..."}));
    				cmbEsc.append($("<option>",{
						value:"Seleccione...",
						text:"Seleccione..."}));
    				for(i=0;i<obj.length;i++){
    					if(i==0){
    						cmbFac.append($("<option>",{
        					value:obj[i].FACU_TRAMITE,
        					text:obj[i].FACU_TRAMITE}));
    					}
    					if(i>0 && obj[i].FACU_TRAMITE!==obj[i-1].FACU_TRAMITE){
    						cmbFac.append($("<option>",{
    						value:obj[i].FACU_TRAMITE,
    						text:obj[i].FACU_TRAMITE}));
    					}
    				}
    				for(i=0;i<obj.length;i++){
    					if(i==0){
    						cmbEsc.append($("<option>",{
        					value:obj[i].ESCU_TRAMITE,
        					text:obj[i].ESCU_TRAMITE}));
    					}
    					if(i>0 && obj[i].ESCU_TRAMITE!==obj[i-1].ESCU_TRAMITE){
    						cmbEsc.append($("<option>",{
    						value:obj[i].ESCU_TRAMITE,
    						text:obj[i].ESCU_TRAMITE}));
    					}
    				}
    			});
    		}
    		$("#input-search").on('keyup',function(){
    			var myTable = $("#tableContent");
    			var codi = $(this).val();

        			$.get("../CSPrincipal",{
        				request : "byCodi",
        				data : codi,
        			    contenType : "application/text"
        			}, function(response){
        				let obj=JSON.parse(response);
        				myTable.empty();
        				if(obj!==null){
        					
        					myTable.append('<tr><td>'+obj.NOMB_TRAMITE+"</td><td>"
        						+obj.ESCU_TRAMITE+"</td><td> S/. "+obj.MONT_TRAMITE+"</td><td>"
        						+"<button id="+obj.CODI_TRAMITE+" class="+"button-23"+" onclick="+"goPay("+obj.CODI_TRAMITE+")"+">Pagar</button>");
        				}
        				});

    		}).keyup();
    		
    		cmbFac.change(function(){
    			let fac = $("#cmbFacultades :selected").val();
    			var myTable = $("#tableContent");

        			$.get("../CSPrincipal",{
        				request : "byFacu",
        				data : fac,
        			    contenType : "application/text"
        			}, function(response){
        				let obj=JSON.parse(response);
        				myTable.empty();
        				cmbEsc.empty();
        				if(obj!==null){
        					for(i=0;i<obj.length;i++){
        						if(i==0){
            						cmbEsc.append($("<option>",{
                					value:obj[i].ESCU_TRAMITE,
                					text:obj[i].ESCU_TRAMITE}));
            					}
            					if(i>0 && obj[i].ESCU_TRAMITE!==obj[i-1].ESCU_TRAMITE){
            						cmbEsc.append($("<option>",{
            						value:obj[i].ESCU_TRAMITE,
            						text:obj[i].ESCU_TRAMITE}));
            					}
            				}
        					for(i=0;i<obj.length;i++){
        					myTable.append('<tr><td>'+obj[i].NOMB_TRAMITE+"</td><td>"
        						+obj[i].ESCU_TRAMITE+"</td><td> S/. "+obj[i].MONT_TRAMITE+"</td><td>"
        						+"<button id="+obj[i].CODI_TRAMITE+" class="+"button-23"+" onclick="+"goPay("+obj[i].CODI_TRAMITE+")"+">Pagar</button>");
        					}
        				}
        			});
    		});
    		cmbEsc.change(function(){
    			let esc = $("#cmbEscuelas :selected").val();
    			var myTable = $("#tableContent");

        			$.get("../CSPrincipal",{
        				request : "byEscu",
        				data : esc,
        			    contenType : "application/text"
        			}, function(response){
        				let obj=JSON.parse(response);
        				myTable.empty();
        				if(obj!==null){
        					for(i=0;i<obj.length;i++){
        					myTable.append('<tr><td>'+obj[i].NOMB_TRAMITE+"</td><td>"
        						+obj[i].ESCU_TRAMITE+"</td><td> S/. "+obj[i].MONT_TRAMITE+"</td><td>"
        						+"<button id="+obj[i].CODI_TRAMITE+" class="+"button-23"+" onclick="+"goPay("+obj[i].CODI_TRAMITE+")"+">Pagar</button>");
        					}
        				}
        			});
    		});
    	});
    </script>
    <script>
    function goPay(data){
    	$.get("../CSRecibo",{
			request : "insert",
			data : data,
		    contenType : "application/text"
		}, function(response){
			if(response==='ok'){
				alert("El pago se ha realizado correctamente");
				window.location.href="MisRecibos.jsp";
			}else{
				alert("Sucedió un error al registrar el pago. Vuelva a intentar.");
			}
		});
	}
    $("#closeSession").click(function() {
		$.post("../CSRecibo", {
			request : "logout",
			data : "logout",
			contenType : "application/text"
		}, function(response) {
			if (response === 'ok') {
				location.href = "../";
			}
		});
	});
    </script>
</body>

</html>
<%}%>