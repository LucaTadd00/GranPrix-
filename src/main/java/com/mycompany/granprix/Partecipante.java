package com.mycompany.granprix;

import java.io.*;
import java.util.*;

public class Partecipante {

	private Auto myAuto;
	private String nome;
	private String cognome;
	private int numero;

	public Partecipante(String nome, String cognome, int numero) {
	    this.nome = nome;
            this.cognome = cognome;
            this.numero = numero;
 
	}
        
        public void setAuto(Auto myAuto) {
             this.myAuto = myAuto;                    
        }
        
        public String getPilota(){
        return nome + " " + cognome;
        }
        
        public int getN(){
        return numero;
        }

}
