package pe.unjfsc.daw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.entity.CERecibo;
import pe.unjfsc.daw.entity.CETramite;
import pe.unjfsc.daw.entity.CEUsuario;
import pe.unjfsc.daw.model.impl.CDRecibo;
import pe.unjfsc.daw.model.impl.CDTramite;
import pe.unjfsc.daw.model.impl.CDUsuario;

@Controller
public class CCSistemaPagoTramite {
	
	public static final Logger LOG = LoggerFactory.getLogger("CCSistemaPagoTramite");
	
	@Autowired
	CEUsuario oCEUsuario;
	CETramite oCETramite;
	CERecibo oCERecibo;
	CDUsuario oCDUsuario;
	CDTramite oCDTramite;
	CDRecibo oCDRecibo;
	LinkedHashSet<CETramite> oListaTramite;
	
	public CCSistemaPagoTramite() {
	}
	
 
    @RequestMapping(value = "/principal.spt")
    public void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String dni = request.getParameter("userDni");
    	LOG.info("[DAW] DNI a validar: {}",dni);
    	CEUsuario user=oCDUsuario.getUserDataFromReniec(dni);
    	LOG.info("[DAW] Usuario logeado: {}",user);
    }
    
    
}
