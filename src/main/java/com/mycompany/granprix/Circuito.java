package com.mycompany.granprix;

import java.io.*;
import java.util.*;

public class Circuito {

	private String nazione;
	private double lunghezza;
	private String nome;

	public Circuito(String nazione, double lunghezza, String nome) {
		this.nazione = nazione;
                this.lunghezza = lunghezza;
                this.nome = nome;
	}
        
        public Circuito() {
		this.nazione = "";
                this.lunghezza = 0;
                this.nome = "";
	}
        
        public double getLunghezza() {
        return lunghezza;
        }

    

}
