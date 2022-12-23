package pe.unjfsc.daw.model.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pe.unjfsc.daw.entity.CEConstantConexion;

public class CDConexion {

	public static Connection getConnection() throws SQLException {
		Connection CONEXION = DriverManager.getConnection(CEConstantConexion.DB, CEConstantConexion.USER, CEConstantConexion.PASS);
		return CONEXION;
	}
}
