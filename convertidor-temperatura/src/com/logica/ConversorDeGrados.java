package com.logica;

public class ConversorDeGrados {
	public static double convertir(GradosEnum grados, int cantidadGrados) {
		if (grados.equals(GradosEnum.CELSIUS_A_FAHRENHEIT)) {
			return 1.8 * cantidadGrados + 32;
		} else {
			return (cantidadGrados - 32) / 1.8;
		}

	}
}
