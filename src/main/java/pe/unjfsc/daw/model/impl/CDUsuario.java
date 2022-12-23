package pe.unjfsc.daw.model.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.unjfsc.daw.entity.CEUsuario;

public class CDUsuario implements CIUsuario {

	private CEUsuario moCEUsuario;
	
	public static final Logger LOG=LoggerFactory.getLogger("CDUsuario");

	public CDUsuario() {
		moCEUsuario=new CEUsuario();
	}

	
	@Override
	public CEUsuario getUserDataFromReniec(String USER_DNI_REQUESTED) {

		try {
			String link = "https://api.apis.net.pe/v1/dni?numero=" + USER_DNI_REQUESTED;
			LOG.info("[DAW] Trying to connect with {}",link);
			
			URL url = new URL(link);
			URLConnection request = url.openConnection();
			request.setReadTimeout(30000);
			request.setRequestProperty("token", "apis-token-1.aTSI1U7KEuT-6bbbCguH-4Y8TI6KS73N");
			request.connect();
			LOG.info("[DAW] Successful Connection!");
			
			InputStream is = (InputStream) request.getContent();

			JsonParser gson = new JsonParser();
			JsonElement root = gson.parseReader(new InputStreamReader(is));
			JsonObject rootobj = root.getAsJsonObject();

			moCEUsuario.setId_usuario(1);
			moCEUsuario.setCod_usuario(USER_DNI_REQUESTED+"-"+new Date().getTime());
			moCEUsuario.setDni_usuario(rootobj.get("numeroDocumento").getAsString());
			moCEUsuario.setNom_usuario(rootobj.get("nombres").getAsString());
			moCEUsuario.setApe_usuario(rootobj.get("apellidoPaterno").getAsString()+" "+rootobj.get("apellidoMaterno").getAsString());
			return moCEUsuario;
			
		} catch (Exception e) {
			LOG.info("[DAW] Error Exception: {}",e);
			return null;
		}
	}

	public void setMoCEUsuario(CEUsuario moCEUsuario) {
		this.moCEUsuario = moCEUsuario;
	}
	
	
}
