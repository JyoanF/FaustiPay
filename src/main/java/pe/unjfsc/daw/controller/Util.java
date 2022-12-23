package pe.unjfsc.daw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {
	public boolean validarNumeros(String data) {
		boolean vC = true;
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			if (!(c >= '0' && c <= '9')) {
				return false;
			}
		}
		return vC;
	}

	public boolean validarSize(String data) {
		boolean vC = false;
		vC = data.length() == 8;
		return vC;
	}

	public static String newCodigo(int cod) {
		String data = String.valueOf(cod);
		String newCod = "";
		for (int i = data.length(); i < 6; i++) {
			newCod += "0";
		}
		newCod += data;
		return newCod;
	}

	public static void closeSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("userSession");
		session.removeAttribute("reciboPago");
	}
}
