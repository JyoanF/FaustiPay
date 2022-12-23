package pe.unjfsc.daw.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.unjfsc.daw.entity.CERecibo;
import pe.unjfsc.daw.entity.CETramite;
import pe.unjfsc.daw.entity.CEUsuario;
import pe.unjfsc.daw.model.impl.ConstanteTramiteSQL;
import pe.unjfsc.daw.model.impl.CDRecibo;
import pe.unjfsc.daw.model.impl.CDTramite;
import pe.unjfsc.daw.model.impl.CDUsuario;
import pe.unjfsc.daw.model.impl.CIRecibo;
import pe.unjfsc.daw.model.impl.CITramite;
import pe.unjfsc.daw.model.impl.CIUsuario;

public class prueba {
	public static final Logger LOG = LoggerFactory.getLogger("prueba");

	public static void main(String[] args) throws IOException {

		Connection conexion = null;

		String user = "postgres";
		String pass = "1234";

		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dawixsistemapagotramite", user,
					pass);
			LOG.info("La conexion fue exitosa!");

			LOG.info("=====> [EVL] Cargando datos desde la Base de Datos en PostgreSQL");
			CETramite moCETramite = new CETramite();
			ArrayList<CETramite> moArrTramites = new ArrayList<CETramite>();
			PreparedStatement oPS = conexion.prepareStatement(ConstanteTramiteSQL.SQL_SELECT_ALL);
			ResultSet oRS = oPS.executeQuery();

			LOG.info("=> [EVL] DataSource        : {} ", DriverManager.class);
			LOG.info("=> [EVL] getConnection     : {} ", conexion);
			LOG.info("=> [EVL] PreparedStatement : {} ", oPS);
			LOG.info("=> [EVL] ResultSet         : {} ", oRS);

			while (oRS.next()) {
				moCETramite.setCODI_TRAMITE(oRS.getInt(2));
				moCETramite.setNOMB_TRAMITE(oRS.getString(3));
				moCETramite.setTIPO_TRAMITE(oRS.getString(4));
				moCETramite.setFACU_TRAMITE(oRS.getString(5));
				moCETramite.setESCU_TRAMITE(oRS.getString(6));
				moCETramite.setMONT_TRAMITE(String.valueOf(oRS.getInt(7)));
				moCETramite.setESTA_TRAMITE(oRS.getInt(8));
				LOG.info("=> [EVL] Objeto Tramite : {} ", moCETramite.toString());

				moArrTramites.add(moCETramite);
				moCETramite = new CETramite();
			}

			LOG.info("=> [EVL] Cantidad de Objetos : {} ", moArrTramites.size());
			LOG.info("=====> [EVL] End method listarAllTipoPlan()");
		} catch (SQLException e) {
			LOG.info("La conexion falló: {}", e);
		}
	}
}
