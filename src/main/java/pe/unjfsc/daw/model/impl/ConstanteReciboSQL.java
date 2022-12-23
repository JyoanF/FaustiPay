package pe.unjfsc.daw.model.impl;

public class ConstanteReciboSQL {
	public static final String SQL_SCHEMA = "public.";
	public static final String SQL_TABLE = "recibos_unjfsc";
	public static final String SQL_INSERT = "INSERT INTO " + SQL_SCHEMA + SQL_TABLE
			+ "(cod_recibo, num_recibo, fecha_recibo, hora_recibo, dni_usuario, cod_tramite, total_recibo) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_DELETE = "DELETE FROM " + SQL_SCHEMA + SQL_TABLE + " WHERE cod_recibo = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + SQL_SCHEMA + SQL_TABLE+" WHERE dni_usuario = ?";
	public static final String SQL_SELECT_BY_COD = "SELECT * FROM " + SQL_SCHEMA + SQL_TABLE+ " WHERE cod_recibo = ?";
}
