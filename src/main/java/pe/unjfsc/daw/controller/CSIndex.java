package pe.unjfsc.daw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.unjfsc.daw.entity.CEUsuario;
import pe.unjfsc.daw.model.impl.CDUsuario;

/**
 * Servlet implementation class CSIndex
 */
public class CSIndex extends HttpServlet {
	public static final Logger LOG= LoggerFactory.getLogger("CSIndex");
	private static final long serialVersionUID = 1L;
	private Util oUtil;
	private CEUsuario moUsuario;
	private CDUsuario moCDUsuario;  
    
    public CSIndex() {
        super();
        oUtil=new Util();
        moUsuario=new CEUsuario();
        moCDUsuario=new CDUsuario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data=request.getParameter("userDni");
		LOG.info("[DAW] User dni: {}",data);
		
		String respuesta="";
		boolean v1 = oUtil.validarSize(data);
		LOG.info("[DAW] Validation 1: {}",v1);
		boolean v2 =oUtil.validarNumeros(data);
		LOG.info("[DAW] Validation 2: {}",v2);
		if(v1&&v2) {
			HttpSession session=request.getSession(true);
			moUsuario = moCDUsuario.getUserDataFromReniec(data);
			session.setAttribute("userSession", moUsuario);
			respuesta="ok";
		}else {
			respuesta="error";
		}
		response.setContentType("text/plain");
		LOG.info("[DAW] Respuesta: {}",respuesta);
		response.getWriter().write(respuesta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
