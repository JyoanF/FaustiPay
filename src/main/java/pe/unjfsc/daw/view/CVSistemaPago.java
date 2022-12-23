package pe.unjfsc.daw.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.unjfsc.daw.model.impl.CIUsuario;

public class CVSistemaPago {
public static final Logger LOG = LoggerFactory.getLogger("CVSistemaPago");
	
	public static void main(String[] args) {
		ApplicationContext oCntx = new ClassPathXmlApplicationContext("/pe/unjfsc/daw/applicationContext.xml");
		LOG.info("[EVL] Instancia Context : {}", oCntx);
		
		CIUsuario oLista = (CIUsuario) oCntx.getBean("idCIUsuario");
		LOG.info("[EVL] Instancia Interface : {}", oLista);
		
		LOG.info("[EVL] User data : {}", oLista.getUserDataFromReniec("72640117"));
	}
}
