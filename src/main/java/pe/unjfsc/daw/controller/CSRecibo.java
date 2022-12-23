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

import com.google.gson.Gson;

import pe.unjfsc.daw.entity.CERecibo;
import pe.unjfsc.daw.entity.CETramite;
import pe.unjfsc.daw.entity.CEUsuario;
import pe.unjfsc.daw.model.impl.CDRecibo;
import pe.unjfsc.daw.model.impl.CDTramite;
import pe.unjfsc.daw.model.impl.CDUsuario;
import pe.unjfsc.daw.model.impl.CIRecibo;
import pe.unjfsc.daw.model.impl.CITramite;

public class CSRecibo extends HttpServlet {
	public static final Logger LOG = LoggerFactory.getLogger("CSRecibo");
	private static final long serialVersionUID = 1L;

	private CIRecibo moCDRecibo;
	private CEUsuario oUsuario;
	private CETramite oTramite;
	private CERecibo oRecibo;
	private CDUsuario moCDUsuario;
	private CITramite moCDTramite;
	private Gson gson;

	public CSRecibo() throws IOException, SQLException {
		super();
		gson=new Gson();
		moCDRecibo = new CDRecibo();
		moCDUsuario = new CDUsuario();
		moCDTramite = new CDTramite();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userRequest = request.getParameter("request").toString();
		String userData = request.getParameter("data").toString();
		LOG.info("[SPT] Request: {}", userData);
		String respuesta = "";
		switch (userRequest) {
		case "insert":
			try {
				HttpSession session = request.getSession();
				oTramite = new CETramite();
				oUsuario = new CEUsuario();
				oUsuario = (CEUsuario) session.getAttribute("userSession");
				oTramite = moCDTramite.buscarTramiteByCod(userData);
				oRecibo = moCDRecibo.generarRecibo(oUsuario, oTramite);
				session.setAttribute("reciboPago", oRecibo);
				respuesta = moCDRecibo.saveRecibo(oRecibo);
			} catch (SQLException ex) {
				LOG.error("[ERROR] Valor: {}", ex);
			}
			break;
		case "delete":
			try {
				moCDRecibo.deleteRecibo(userData);
				respuesta = "ok";
			} catch (SQLException ex) {
				LOG.error("[ERROR] No se elimino el registro: {}", ex);
			}
			break;

		case "consult":
			try {
				HttpSession session = request.getSession();
				oRecibo = new CERecibo();
				oRecibo=moCDRecibo.searchRecibo(userData);
				respuesta = gson.toJson(oRecibo);
				LOG.info("[EVL] Objeto RECIBO     : {} ", respuesta);
				session.removeAttribute("reciboPago");
				session.setAttribute("reciboPago", oRecibo);
			} catch (SQLException ex) {
				LOG.error("[ERROR] Valor: {}", ex);
			}
			break;
		case "logout":
			try {
				Util.closeSession(request, response);
				LOG.info("[EVL] Se han eliminado los elementos de la sesion. Cerrando...");
				respuesta = "ok";
			} catch (IOException ex) {
				LOG.error("[ERROR] No se elimino el registro: {}", ex);
			}
			break;
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
