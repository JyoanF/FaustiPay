package pe.unjfsc.daw.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.unjfsc.daw.entity.CERecibo;
import pe.unjfsc.daw.entity.CETramite;
import pe.unjfsc.daw.entity.CEUsuario;

public class CDRecibo implements CIRecibo {

	private CERecibo moCERecibo;
	private LocalDateTime moTime;
	private Connection oCxn = null;
	private LinkedHashSet<CERecibo> moListRecibos;

	public static final Logger LOG = LoggerFactory.getLogger("CDRecibo");

	public CDRecibo() {
		moCERecibo = new CERecibo();
	}

	@Override
	public CERecibo generarRecibo(CEUsuario moUsuario, CETramite moTramite) {
		moTime = LocalDateTime.now();
		moCERecibo.setCod_recibo(
				(moTime.getYear()%1000)+"" + moTime.getMonthValue()+"" + moTime.getDayOfMonth()+""+moTime.getHour()+""+moTime.getMinute()+""+moTime.getSecond()+""+ moUsuario.getDni_usuario());
		moCERecibo.setNum_recibo(moTime.getDayOfMonth() + "" + moTime.getMonthValue() + "" + moTime.getYear()+""+moTime.getSecond());
		moCERecibo.setFecha_recibo(moTime.getDayOfMonth() + "/" + moTime.getMonthValue() + "/" + moTime.getYear());
		moCERecibo.setHora_recibo(moTime.getHour() + ":" + moTime.getMinute() + ":" + moTime.getSecond());
		moCERecibo.setDni_usuario(moUsuario.getDni_usuario());
		moCERecibo.setCod_tramite("" + moTramite.getCODI_TRAMITE());
		moCERecibo.setTotal_recibo(moTramite.getMONT_TRAMITE().replaceAll(",", "."));
		return moCERecibo;
	}

	@Override
	public String saveRecibo(CERecibo moRecibo){
		try {
			LOG.info("=====> [EVL] Start method grabarTipoPlan(CE01TipoPlan poCETipoPlan)");

			oCxn = CDConexion.getConnection();
			PreparedStatement oPS = oCxn.prepareStatement(ConstanteReciboSQL.SQL_INSERT);

			LOG.info("=> [EVL] getConnection     : {} ", oCxn);
			LOG.info("=> [EVL] PreparedStatement : {} ", oPS);

			oPS.setString(1, moRecibo.getCod_recibo());
			oPS.setString(2, moRecibo.getNum_recibo());
			oPS.setString(3, moRecibo.getFecha_recibo());
			oPS.setString(4, moRecibo.getHora_recibo());
			oPS.setString(5, moRecibo.getDni_usuario());
			oPS.setString(6, moRecibo.getCod_tramite());
			oPS.setString(7, moRecibo.getTotal_recibo());

			LOG.info("=> [EVL] PreparedStatement : {} ", oPS);

			oPS.executeUpdate();
			oPS.close();
			oCxn.close();
			LOG.info("=====> [EVL] End method saveRecibo(CERecibo moRecibo)");
			return "ok";
		} catch (SQLException ex) {
			LOG.info("=> ERROR : {} ", ex);
			return "error";
		}
	}

	@Override
	public void deleteRecibo(String psCodigo) throws SQLException {
		LOG.info("=====> [EVL] Start method deleteRecibo(String psCodigo)");

		oCxn = CDConexion.getConnection();
		PreparedStatement oPS = oCxn.prepareStatement(ConstanteReciboSQL.SQL_DELETE);

		LOG.info("=> [EVL] getConnection     : {} ", oCxn);
		LOG.info("=> [EVL] PreparedStatement : {} ", oPS);

		oPS.setString(1, psCodigo);

		LOG.info("=> [EVL] PreparedStatement : {} ", oPS);

		oPS.executeUpdate();
		oPS.close();
		oCxn.close();

		LOG.info("=====> [EVL] End method deleteRecibo(String psCodigo)");
	}

	@Override
	public CERecibo searchRecibo(String psCodigo) throws SQLException {
		LOG.info("=====> [EVL] Start method searchRecibo(String psCodigo)");

		oCxn = CDConexion.getConnection();
		moCERecibo = new CERecibo();
		PreparedStatement oPS = oCxn.prepareStatement(ConstanteReciboSQL.SQL_SELECT_BY_COD);

		LOG.info("=> [EVL] getConnection     : {} ", oCxn);
		LOG.info("=> [EVL] PreparedStatement : {} ", oPS);

		oPS.setString(1, psCodigo);
		ResultSet oRS = oPS.executeQuery();

		LOG.info("=> [EVL] PreparedStatement : {} ", oPS);
		LOG.info("=> [EVL] ResultSet         : {} ", oRS);

		while (oRS.next()) {
			moCERecibo.setCod_recibo(oRS.getString(2));
			moCERecibo.setNum_recibo(oRS.getString(3));
			moCERecibo.setFecha_recibo(oRS.getString(4));
			moCERecibo.setHora_recibo(oRS.getString(5));
			moCERecibo.setDni_usuario(oRS.getString(6));
			moCERecibo.setCod_tramite(oRS.getString(7));
			moCERecibo.setTotal_recibo(oRS.getString(8));
		}
		LOG.info("=> [EVL] Objeto Recibo : {} ", moCERecibo.toString());
		oPS.close();
		oCxn.close();

		LOG.info("=====> [EVL] End method searchRecibo(String psCodigo)");
		return moCERecibo;
	}

	@Override
	public LinkedHashSet<CERecibo> listarAllRecibo(String DNI_USUARIO) throws SQLException {
		LOG.info("=====> [EVL] Start method listarAllRecibo()");

		oCxn = CDConexion.getConnection();
		moCERecibo = new CERecibo();
		moListRecibos = new LinkedHashSet<CERecibo>();
		PreparedStatement oPS = oCxn.prepareStatement(ConstanteReciboSQL.SQL_SELECT_ALL);

		LOG.info("=> [EVL] getConnection     : {} ", oCxn);

		oPS.setString(1, DNI_USUARIO);
		ResultSet oRS = oPS.executeQuery();

		LOG.info("=> [EVL] PreparedStatement : {} ", oPS);
		LOG.info("=> [EVL] ResultSet         : {} ", oRS);

		while (oRS.next()) {
			moCERecibo.setCod_recibo(oRS.getString(2));
			moCERecibo.setNum_recibo(oRS.getString(3));
			moCERecibo.setFecha_recibo(oRS.getString(4));
			moCERecibo.setHora_recibo(oRS.getString(5));
			moCERecibo.setDni_usuario(oRS.getString(6));
			moCERecibo.setCod_tramite(oRS.getString(7));
			moCERecibo.setTotal_recibo(oRS.getString(8));
			LOG.info("=> [EVL] Objeto Recibo : {} ", moCERecibo.toString());

			moListRecibos.add(moCERecibo);
			moCERecibo = new CERecibo();
		}

		LOG.info("=> [EVL] Cantidad de Objetos : {} ", moListRecibos.size());
		LOG.info("=====> [EVL] End method listarAllRecibo()");
		return moListRecibos;
	}

	public void setMoCERecibo(CERecibo moCERecibo) {
		this.moCERecibo = moCERecibo;
	}
}
