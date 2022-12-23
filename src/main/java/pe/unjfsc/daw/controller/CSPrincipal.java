package pe.unjfsc.daw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.Gson;

import pe.unjfsc.daw.entity.CERecibo;
import pe.unjfsc.daw.entity.CETramite;
import pe.unjfsc.daw.entity.CEUsuario;
import pe.unjfsc.daw.model.impl.CDRecibo;
import pe.unjfsc.daw.model.impl.CDTramite;
import pe.unjfsc.daw.model.impl.CDUsuario;
import pe.unjfsc.daw.model.impl.CIRecibo;
import pe.unjfsc.daw.model.impl.CITramite;

/**
 * Servlet implementation class CSPrincipal
 */
public class CSPrincipal extends HttpServlet {
	public static final Logger LOG= LoggerFactory.getLogger("CSPrincipal");
	private static final long serialVersionUID = 1L;
	private Util oUtil;
	private CEUsuario moUsuario;
	private CETramite oTramite;
	private CERecibo oRecibo;
	private CDUsuario moCDUsuario;
	private CITramite moCDTramite;
	private CIRecibo moCDRecibo;
	private LinkedHashSet<CETramite> moListTramite;
	private Gson gson;
    
    public CSPrincipal() throws IOException, SQLException{
        super();
        gson=new Gson();
        oUtil=new Util();
        moUsuario=new CEUsuario();
        moCDUsuario=new CDUsuario();
        moCDTramite = new CDTramite();
        moCDRecibo = new CDRecibo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userRequest=request.getParameter("request").toString();
		String userData = request.getParameter("data").toString();
		LOG.info("Pedido: {}",userData);
		String respuesta="";
		switch(userRequest) {
			case "byType":
				moListTramite = new LinkedHashSet<CETramite>();
				moListTramite = moCDTramite.filterByType(userData);
				respuesta=gson.toJson(moListTramite);
				break;
			case "byCodi":
				oTramite=new CETramite();
				oTramite=moCDTramite.buscarTramiteByCod(userData);
				respuesta=gson.toJson(oTramite);
				break;
			case "toPay":
				HttpSession session=request.getSession(true);
				oTramite=new CETramite();
				oTramite=moCDTramite.buscarTramiteByCod(userData);
				oRecibo = new CERecibo();
				moUsuario=(CEUsuario) session.getAttribute("userSession");
				oRecibo = moCDRecibo.generarRecibo(moUsuario, oTramite);
				session.setAttribute("reciboPago", oRecibo);
				respuesta = "ok";
				break;
			case "byFacu":
				moListTramite = new LinkedHashSet<CETramite>();
				moListTramite = moCDTramite.filterByFacultad(userData);
				respuesta=gson.toJson(moListTramite);
				break;
			case "byEscu":
				moListTramite = new LinkedHashSet<CETramite>();
				moListTramite = moCDTramite.filterByEscuela(userData);
				respuesta=gson.toJson(moListTramite);
				break;
		}
		response.setContentType("text/plain");
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
