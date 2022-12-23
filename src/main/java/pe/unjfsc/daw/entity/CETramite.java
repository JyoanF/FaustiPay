package pe.unjfsc.daw.entity;

public class CETramite {
	public int CODI_TRAMITE;
	public String NOMB_TRAMITE;
	public String TIPO_TRAMITE;
	public String FACU_TRAMITE;
	public String ESCU_TRAMITE;
	public String MONT_TRAMITE;
	public int ESTA_TRAMITE;
	
	public CETramite() {
		
	}

	public CETramite(int cODI_TRAMITE, String nOMB_TRAMITE, String tIPO_TRAMITE, String fACU_TRAMITE,
			String eSCU_TRAMITE, String mONT_TRAMITE, int eSTA_TRAMITE) {
		super();
		CODI_TRAMITE = cODI_TRAMITE;
		NOMB_TRAMITE = nOMB_TRAMITE;
		TIPO_TRAMITE = tIPO_TRAMITE;
		FACU_TRAMITE = fACU_TRAMITE;
		ESCU_TRAMITE = eSCU_TRAMITE;
		MONT_TRAMITE = mONT_TRAMITE;
		ESTA_TRAMITE = eSTA_TRAMITE;
	}

	public int getCODI_TRAMITE() {
		return CODI_TRAMITE;
	}

	public String getNOMB_TRAMITE() {
		return NOMB_TRAMITE;
	}

	public String getTIPO_TRAMITE() {
		return TIPO_TRAMITE;
	}

	public String getFACU_TRAMITE() {
		return FACU_TRAMITE;
	}

	public String getESCU_TRAMITE() {
		return ESCU_TRAMITE;
	}

	public String getMONT_TRAMITE() {
		return MONT_TRAMITE;
	}

	public int getESTA_TRAMITE() {
		return ESTA_TRAMITE;
	}

	public void setCODI_TRAMITE(int cODI_TRAMITE) {
		CODI_TRAMITE = cODI_TRAMITE;
	}

	public void setNOMB_TRAMITE(String nOMB_TRAMITE) {
		NOMB_TRAMITE = nOMB_TRAMITE;
	}

	public void setTIPO_TRAMITE(String tIPO_TRAMITE) {
		TIPO_TRAMITE = tIPO_TRAMITE;
	}

	public void setFACU_TRAMITE(String fACU_TRAMITE) {
		FACU_TRAMITE = fACU_TRAMITE;
	}

	public void setESCU_TRAMITE(String eSCU_TRAMITE) {
		ESCU_TRAMITE = eSCU_TRAMITE;
	}

	public void setMONT_TRAMITE(String mONT_TRAMITE) {
		MONT_TRAMITE = mONT_TRAMITE;
	}

	public void setESTA_TRAMITE(int eSTA_TRAMITE) {
		ESTA_TRAMITE = eSTA_TRAMITE;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CETramite [CODI_TRAMITE=");
		builder.append(CODI_TRAMITE);
		builder.append(", NOMB_TRAMITE=");
		builder.append(NOMB_TRAMITE);
		builder.append(", TIPO_TRAMITE=");
		builder.append(TIPO_TRAMITE);
		builder.append(", FACU_TRAMITE=");
		builder.append(FACU_TRAMITE);
		builder.append(", ESCU_TRAMITE=");
		builder.append(ESCU_TRAMITE);
		builder.append(", MONT_TRAMITE=");
		builder.append(MONT_TRAMITE);
		builder.append(", ESTA_TRAMITE=");
		builder.append(ESTA_TRAMITE);
		builder.append("]");
		return builder.toString();
	}
	
}
