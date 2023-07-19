package com.logica;

public class ConvertirStringAEnum {

	public static GradosEnum convertir(String valorEnum) {
		GradosEnum divisas = GradosEnum.valueOf(valorEnum); // convirtiendo de String a Enum
		return divisas;

	}
}
