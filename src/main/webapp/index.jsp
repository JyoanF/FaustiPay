<!DOCTYPE html>

<%@page import="pe.unjfsc.daw.controller.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page</title>
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,600,0,0" />

    <link rel="stylesheet" href="css/index/stylos.css">
    <link rel="icon" href="./img/ico/fp.ico">
    <script src="https://kit.fontawesome.com/aa07980de8.js" crossorigin="anonymous"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="login-left">
            <div class="login-header">
                <img src="img/index/Logo.svg" alt="Logo">
                <p>Ingrese su numero de indentificacion</p>
            </div>
            <div class="login-form" >
                <div class="login-form-content">
                    <div class="form-item">
                        <label for="emailForm">DNI</label>
                        <div class="group_icon">
                            <input type="text" id="emailForm" name="userDNI" maxlength="8" autofocus>
                            <img src="img/index/id-card-solid.svg">
                        </div>
                        <!-- 
                        <div class="captcha">
                            <span class="msg-error error" ></span>
                            <div id="recaptcha" class="g-recaptcha" data-sitekey="6Lez_y0jAAAAAGuOHuBPFDph23eR7fN5OxeO9myN" >
                            </div>
                        </div>
                         -->
                    </div>
                    <button type="submit" id="btnIngresar">Ingresar</button>

                </div>
            </div>
        </div>
        <div class="login-right">
            <img src="img/index/9-1 2.svg" alt="image">
        </div>
        <co:url value="/html/principal.jsp" var="principalUrl"></co:url>
    </div>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#btnIngresar").click(function(event){	
    			var dni = $("#emailForm").val();
    			$.get("CSIndex", {
    			    userDni : dni,
    			    contenType : "application/text"
    			}, function(responseText) {
    			    if(responseText==='ok'){
    			    	window.location.href='${principalUrl}';
    			    }
    			    if(responseText==='error'){
    			    	alert("Algo salió mal! :(");
    			    }
    			});
    		});
    	});
    </script>
</body>

</html>
