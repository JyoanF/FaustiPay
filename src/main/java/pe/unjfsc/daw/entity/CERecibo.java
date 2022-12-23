package pe.unjfsc.daw.entity;

public class CERecibo {
	public String cod_recibo;
	public String num_recibo;
	public String fecha_recibo;
	public String hora_recibo;
	public String dni_usuario;
	public String cod_tramite;
	public String total_recibo;
	
	public CERecibo() {
	}

	public CERecibo(String cod_recibo, String num_recibo, String fecha_recibo, String hora_recibo, String dni_usuario,
			String cod_tramite, String total_recibo) {
		super();
		this.cod_recibo = cod_recibo;
		this.num_recibo = num_recibo;
		this.fecha_recibo = fecha_recibo;
		this.hora_recibo = hora_recibo;
		this.dni_usuario = dni_usuario;
		this.cod_tramite = cod_tramite;
		this.total_recibo = total_recibo;
	}

	public String getCod_recibo() {
		return cod_recibo;
	}

	public String getNum_recibo() {
		return num_recibo;
	}

	public String getFecha_recibo() {
		return fecha_recibo;
	}

	public String getHora_recibo() {
		return hora_recibo;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public String getCod_tramite() {
		return cod_tramite;
	}

	public String getTotal_recibo() {
		return total_recibo;
	}

	public void setCod_recibo(String cod_recibo) {
		this.cod_recibo = cod_recibo;
	}

	public void setNum_recibo(String num_recibo) {
		this.num_recibo = num_recibo;
	}

	public void setFecha_recibo(String fecha_recibo) {
		this.fecha_recibo = fecha_recibo;
	}

	public void setHora_recibo(String hora_recibo) {
		this.hora_recibo = hora_recibo;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	public void setCod_tramite(String cod_tramite) {
		this.cod_tramite = cod_tramite;
	}

	public void setTotal_recibo(String total_recibo) {
		this.total_recibo = total_recibo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CERecibo [cod_recibo=");
		builder.append(cod_recibo);
		builder.append(", num_recibo=");
		builder.append(num_recibo);
		builder.append(", fecha_recibo=");
		builder.append(fecha_recibo);
		builder.append(", hora_recibo=");
		builder.append(hora_recibo);
		builder.append(", dni_usuario=");
		builder.append(dni_usuario);
		builder.append(", cod_tramite=");
		builder.append(cod_tramite);
		builder.append(", total_recibo=");
		builder.append(total_recibo);
		builder.append("]");
		return builder.toString();
	}
	
}
