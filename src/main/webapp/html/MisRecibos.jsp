<%@page import="pe.unjfsc.daw.controller.Util"%>
<%@page import="pe.unjfsc.daw.entity.CETramite"%>
<%@page import="pe.unjfsc.daw.entity.CEUsuario"%>
<%@page import="pe.unjfsc.daw.entity.CERecibo"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="pe.unjfsc.daw.model.impl.CDRecibo"%>
<%@page import="pe.unjfsc.daw.model.impl.CIRecibo"%>
<%@page import="pe.unjfsc.daw.model.impl.CDTramite"%>
<%@page import="pe.unjfsc.daw.model.impl.CITramite"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
CEUsuario oUser = (CEUsuario) session.getAttribute("userSession");
if (oUser == null) {
	response.sendRedirect("../");
} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Recibos</title>
<link rel="icon" href="../img/ico/fp.ico">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<style>
table {
	width: 90%;
	min-height: 280px;
}

section {
	padding: 0px 40px;
}

h3 {
	color: #007094;
}

iframe {
	width: 100%;
	height: 480px;
}

footer p {
	color: #007094;
}
</style>
<body>
	<nav class="navbar">
		<div class="container-fluid">
			<img class="navbar-brand" src="../img/pay/Logo.svg" height="80px">
			<form class="d-flex" role="search">
				<div class="dropdown dropstart">
					<button class="btn btn-outline-primary dropdown-toggle"
						type="button" data-bs-toggle="dropdown" aria-expanded="false">
						<%
						out.print(oUser.getNom_usuario());
						%>
					</button>
					<ul class="dropdown-menu dropdown-menu-info">
						<li><a class="dropdown-item" href="./principal.jsp">Nuevo
								pago</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" id="closeSession" style="cursor:pointer;">Cerrar
								Sesión</a></li>
					</ul>
				</div>


			</form>
		</div>
	</nav>
	<br>
	<figure class="text-center">
		<h3>MIS RECIBOS</h3>
	</figure>
	<br>
	<section>
		<table class="table table-stripped">
			<thead class="table-light">
				<tr>
					<th scope="col"><center>#</center></th>
					<th scope="col"><center>Nº OPERACION</center></th>
					<th scope="col">CONCEPTO</th>
					<th scope="col">ESCUELA</th>
					<th scope="col"><center>FECHA Y HORA</center></th>
					<th scope="col"><center>OPERACIONES</center></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<%
				CIRecibo moCDRecibo = new CDRecibo();
				CITramite moCDTramite = new CDTramite();
				CETramite oTramite;
				LinkedHashSet<CERecibo> listRecibo = new LinkedHashSet<CERecibo>();
				listRecibo = moCDRecibo.listarAllRecibo(oUser.getDni_usuario());
				int cont = 1;
				String codi = "";
				for (CERecibo oRecibo : listRecibo) {
					codi = "";
					codi = oRecibo.getCod_recibo();
					oTramite = new CETramite();
					out.print("<script>let cod" + cont + "=\"" + codi + "\"; </script>");
					oTramite = moCDTramite.buscarTramiteByCod(oRecibo.getCod_tramite());
					out.print("<tr id=row" + cont + ">");
					out.print("<td><strong><center>" + cont + "</center></strong></td>");
					out.print("<td><center>" + oRecibo.getNum_recibo() + "</center></td>");
					out.print("<td>" + oTramite.getNOMB_TRAMITE() + "</td>");
					out.print("<td>" + oTramite.getESCU_TRAMITE() + "</td>");
					out.print("<td><center>" + oRecibo.getFecha_recibo() + "  " + oRecibo.getHora_recibo() + "</center></td>");

					out.print(
					"<td><center><button class=\"btn btn-outline-success viewer\" data-bs-toggle=\"modal\" data-bs-target=\"#dataViewerRecibo\" onclick=\"mostrarRecibo(");
					out.print("cod" + cont);
					out.print(");\"><img src=\"../img/svg/ojo.svg\" height=\"20px\"></button>");
					out.print("\t\t");
					out.print("<button class=\"btn btn-outline-danger \" onclick=\"deleteRecibo(");
					out.print("cod" + cont + "," + cont);
					out.print(");\"><img src=\"../img/svg/basura.svg\" height=\"20px\"></button></center></td>");
					out.print("</tr>\n");
					cont++;
				}
				%>
			</tbody>
		</table>
	</section>
	<div class="modal fade show" id="dataViewerRecibo" tabindex="-1"
		aria-labelledby="exampleModalFullscreenLabel" style="display: none;"
		aria-modal="true" role="dialog">
		<div class="modal-dialog modal-fullscreen">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-4" id="exampleModalFullscreenLabel">
						Recibo Nº: <span id="nro-recibo"></span>
					</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<footer class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col text-center">
				<p>
					<strong>Universidad Nacional José Faustino Sánchez Carrión</strong>
				</p>
				<p>© Copyright 2022 - FaustiPay</p>
			</div>
			<div class="col text-end"></div>
		</div>
	</footer>
</body>
<script type="text/javascript">
	function mostrarRecibo(data) {
		$.get("../CSRecibo", {
			request : "consult",
			data : data,
			contenType : "application/text"
		},
				function(response) {
					if (response !== null) {
						let objRecibo = JSON.parse(response);
						$("#nro-recibo").text(objRecibo.num_recibo);
						$(".modal-body").empty();
						$(".modal-body").append(
								"<iframe src=\"./pay.jsp\"> </iframe>");
						$("#dataViewerRecibo").modal("show");
					} else {
						alert("Ha sucedido un error.");
					}
				});
	}
	function deleteRecibo(data, index) {
		$.get("../CSRecibo", {
			request : "delete",
			data : data,
			contenType : "application/text"
		}, function(response) {
			if (response === 'ok') {
				$("#row" + index).remove();
			} else {
				alert("No se realizó la información");
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
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</html>
<%
}
%>