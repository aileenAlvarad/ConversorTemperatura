package com.logica;

public class Validaciones {

	public static boolean validarString(String stringAValidarSiEsEntero) {
		try {
			Integer.parseInt(stringAValidarSiEsEntero);
			return true;
		} catch (NumberFormatException ex) {

		}
		return false;
	}
}
