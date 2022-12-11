package com.prpymes.microservicios.app.almacenes.commons.services;

import java.util.Random;

public class ServiceBarcode {
	Random numAleatorio1 ;
	public ServiceBarcode(){
		numAleatorio1 = new Random();
	}
	String number = "0123456789";
	
	public String GenerateBarcode() {
		String res = "";
		
		for(int i = 0; i < number.length(); i++) {
			int x = numAleatorio1.nextInt(number.length());
			res= res + number.charAt(x);
		}
		return res;
	}
}
