package GranP.GranPrix;

import java.io.*;
import java.util.*;

public class gara implements Runnable{

	private Circuito circuito;
	private int maxPits;
	private int nGiri;
	private ArrayList<Auto> auto;
	private ArrayList<Partecipante> partecipanti;

	public gara(Circuito circuito, int maxPits, int nGiri, ArrayList<Auto> auto, ArrayList<Partecipante> partecipanti) {
		this.circuito = circuito;
                this.maxPits = maxPits;
                this.nGiri = nGiri;
                this.auto = auto;
                this.partecipanti = partecipanti;
	}

	public void run() {
		partenza();
	}
        
        public void partenza() {
        
        }

}
