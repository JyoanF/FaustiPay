package pe.unjfsc.daw.model.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import pe.unjfsc.daw.entity.CEConstantConexion;
import pe.unjfsc.daw.entity.CETramite;

public class CDTramite implements CITramite {

	private static final Logger LOG = LoggerFactory.getLogger(CDTramite.class);
	private ArrayList<CETramite> moArrTramites;
	private CETramite[] tramArray;
	private LinkedHashSet<CETramite> moListTramitesRequested;
	private String urlResource = "src/main/resources/input/tramites.json";
	private Path pathResource;
	private String jsonString;
	private Gson gson;
	private CETramite moCETramite;
	
	private DataSource dataSource;
	private Connection oCxn = null;

	public CDTramite() throws IOException, SQLException {
		/*
		moArrTramites = new ArrayList<CETramite>();
		pathResource = Paths.get(urlResource);
		jsonString = Files.readAllLines(pathResource).stream().collect(Collectors.joining(System.lineSeparator()));

		gson = new Gson();

		tramArray = gson.fromJson(jsonString, CETramite[].class);
		for (CETramite oT : tramArray) {
			moArrTramites.add(oT);
		}
		*/
		
		cargarDatosFromDB();
	}

	@Override
	public CETramite buscarTramiteByCod(String cod_tramite) {

		for (CETramite oT : moArrTramites) {
			String codTram=String.valueOf(oT.getCODI_TRAMITE());
			if (codTram.equals(cod_tramite)) {
				return oT;
			}
		}

		return null;
	}

	@Override
	public LinkedHashSet<CETramite> filterByType(String TIPO) {
		moListTramitesRequested = new LinkedHashSet<CETramite>();
		for (CETramite oT : moArrTramites) {
			String tipoTram=oT.getTIPO_TRAMITE();
			if (tipoTram.equals(TIPO)) {
				moListTramitesRequested.add(oT);
			}
		}
		return moListTramitesRequested;
	}

	@Override
	public LinkedHashSet<CETramite> filterByEscuela(String ESCUELA) {
		moListTramitesRequested = new LinkedHashSet<CETramite>();
		for (CETramite oT : moArrTramites) {
			String escuTram=oT.getESCU_TRAMITE();
			if (escuTram.equals(ESCUELA)) {
				moListTramitesRequested.add(oT);
			}
		}
		return moListTramitesRequested;
	}

	@Override
	public LinkedHashSet<CETramite> filterByFacultad(String FACULTAD) {
		moListTramitesRequested = new LinkedHashSet<CETramite>();
		for (CETramite oT : moArrTramites) {
			String facuTram=oT.getFACU_TRAMITE();
			if (facuTram.equals(FACULTAD)) {
				moListTramitesRequested.add(oT);
			}
		}
		return moListTramitesRequested;
	}
	
	public void cargarDatosFromDB() throws SQLException{
		LOG.info("=====> [EVL] Cargando datos desde la Base de Datos en PostgreSQL");
		moCETramite = new CETramite();
		oCxn = CDConexion.getConnection();
		moArrTramites = new ArrayList<CETramite>();
		PreparedStatement oPS = oCxn.prepareStatement(ConstanteTramiteSQL.SQL_SELECT_ALL);
		ResultSet oRS = oPS.executeQuery();
		
		LOG.info("=> [EVL] DataSource        : {} ", dataSource);
		LOG.info("=> [EVL] getConnection     : {} ", oCxn);
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
			
			moArrTramites.add(moCETramite);
			moCETramite = new CETramite();
		}
		
		LOG.info("=> [EVL] Cantidad de Objetos : {} ", moArrTramites.size());
		LOG.info("=====> [EVL] End method listarAllTipoPlan()");
	}

	public void setMoCETramite(CETramite moCETramite) {
		this.moCETramite = moCETramite;
	}
	
}
