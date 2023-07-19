package com.logica;

public class CalcularTipoDeGradoSeleccionado {

	public static void main(String[] args) {
		// calcularTipo("FAHRENHEIT_A_CELSIUS");
		System.out.println(calcularTipo("FAHRENHEIT_A_CELSIUS"));
	}

	public static String calcularTipo(String tipoConversionDeGrados) {
		int indiceGuionBajo = tipoConversionDeGrados.lastIndexOf("_") + 1;
		return tipoConversionDeGrados.substring(indiceGuionBajo);
	}
}
