package com.mycompany.granprix;

import java.io.*;
import java.util.*;

public class Gara extends Thread {

	private Circuito circuito;
	private int maxPits;
	private int nGiri;
	private ArrayList<Auto> auto;
	private ArrayList<Partecipante> partecipanti;
        private ArrayList<Auto> classifica;
        private GestoreGara gestore;

	public Gara(Circuito circuito, int maxPits, int nGiri, ArrayList<Auto> auto, ArrayList<Partecipante> partecipanti, GestoreGara gestore) {
		this.circuito = circuito;
                this.maxPits = maxPits;
                this.nGiri = nGiri;
                this.auto = auto;
                this.partecipanti = partecipanti;
                this.gestore = gestore;
    this.classifica.add(auto.get(0));
	}
        
        public void run() {
        for (int i = 1; i < auto.size(); i++) {
            auto.get(i).start();           
        }
        
        
         while(classifica.size() != auto.size() + 1) {
            for(int i = 0; i > auto.size(); i++)
              if(auto.get(i).getRunning() == false && auto.get(i).getSaved() == false) {
                 classifica.add(auto.get(i));
                 auto.get(i).setSaved(true);
                        
              }
        }
         classifica.remove(auto.get(0));
        
        for (int i = 0; i < auto.size(); i++) {
        try{
            auto.get(i).join();
        }catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } }
        System.out.println("GARA CONCLUSA");
        
        for (int i = 1; i < auto.size(); i++) {
        classifica.get(i).Stampa(i);
        }
        
        }
        
        public int getnGiri() {
        return nGiri;
        }
        
        public Circuito getCircuito() {
        return circuito;
        }
        
        public ArrayList<Auto> getnAuto() {
        return auto;
        }
        
        public GestoreGara getGestore() {
        return gestore;
        }
        
        }
        
       
