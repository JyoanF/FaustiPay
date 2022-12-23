package pe.unjfsc.daw.model.impl;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import pe.unjfsc.daw.entity.CERecibo;
import pe.unjfsc.daw.entity.CETramite;
import pe.unjfsc.daw.entity.CEUsuario;

public interface CIRecibo {
	public CERecibo generarRecibo(CEUsuario moUsuario,CETramite moTramite);
	
	public String saveRecibo(CERecibo moRecibo) throws SQLException;
	public void deleteRecibo(String psCodigo) throws SQLException;
	public CERecibo searchRecibo(String psCodigo) throws SQLException;
	public LinkedHashSet<CERecibo> listarAllRecibo(String DNI_USUARIO) throws SQLException;
}
