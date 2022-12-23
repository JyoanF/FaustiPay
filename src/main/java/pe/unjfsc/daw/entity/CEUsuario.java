package pe.unjfsc.daw.entity;

public class CEUsuario {
	
	public int id_usuario;
	public String cod_usuario;
	public String dni_usuario;
	public String nom_usuario;
	public String ape_usuario;
	
	public CEUsuario() {
		
	}

	public CEUsuario(int id_usuario, String cod_usuario, String dni_usuario, String nom_usuario, String ape_usuario) {
		this.id_usuario = id_usuario;
		this.cod_usuario = cod_usuario;
		this.dni_usuario = dni_usuario;
		this.nom_usuario = nom_usuario;
		this.ape_usuario = ape_usuario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public String getCod_usuario() {
		return cod_usuario;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public String getApe_usuario() {
		return ape_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setCod_usuario(String cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public void setApe_usuario(String ape_usuario) {
		this.ape_usuario = ape_usuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CEUsuario [id_usuario=");
		builder.append(id_usuario);
		builder.append(", cod_usuario=");
		builder.append(cod_usuario);
		builder.append(", dni_usuario=");
		builder.append(dni_usuario);
		builder.append(", nom_usuario=");
		builder.append(nom_usuario);
		builder.append(", ape_usuario=");
		builder.append(ape_usuario);
		builder.append("]");
		return builder.toString();
	}
	
}
