package pe.unjfsc.daw.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CCRecibo {
	public static final Logger LOG = LoggerFactory.getLogger("CCRecibo");
	
	@RequestMapping(value="/MisRecibos.spt")
	public ModelAndView recibosRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("[EVL] Request and response : {} {}", request, response);
		
		return new ModelAndView();
	}
}
