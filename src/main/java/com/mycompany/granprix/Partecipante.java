package GranP.GranPrix;

import java.io.*;
import java.util.*;

public class Partecipante extends Auto {

	private Auto myAuto;
	private String nome;
	private String cognome;
	private int numero;

	public Partecipante(String nome, String cognome, int numero, Auto auto) {
	    this.nome = nome;
            this.cognome = cognome;
            this.numero = numero;
            this.myAuto = auto;
 
	}

}
