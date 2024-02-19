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
                this.classifica = new ArrayList<Auto>();
	}
        
        @Override
        public void run() {    
            
        for (int i = 0; i < auto.size(); i++) {
            auto.get(i).start();           
        }
        
ArrayList<Auto> arrivateAlTraguardo = new ArrayList<>();
ArrayList<Auto> danneggiate = new ArrayList<>();

while (arrivateAlTraguardo.size() +  danneggiate.size() != auto.size()) {
    // Aggiungi le auto arrivate al traguardo alla lista temporanea
    for (int i = 0; i < auto.size(); i++) {
        if (auto.get(i).getRunning() == false && auto.get(i).getDamage() == false && auto.get(i).getSaved() == false) {
            arrivateAlTraguardo.add(auto.get(i));
            auto.get(i).setSaved(true);
        }
    }

    // Aggiungi le auto danneggiate alla lista temporanea
    for (int i = 0; i < auto.size(); i++) {
        if (auto.get(i).getDamage() == true && auto.get(i).getSaved() == false) {
            danneggiate.add(auto.get(i));
            auto.get(i).setSaved(true);
        }
    }
}
    for (int i = 0; i < auto.size(); i++) {
        try{
            auto.get(i).join();
        }catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } }

    // Aggiungi le auto arrivate al traguardo alla classifica
    classifica.addAll(arrivateAlTraguardo);
    // Aggiungi le auto danneggiate alla classifica
    classifica.addAll(danneggiate);
      
        System.out.println("GARA CONCLUSA");
        
        for (int i = 0; i < classifica.size(); i++) {
        System.out.println(classifica.get(i).Stampa(i));
        }
        
        Scrittore scrittore = new Scrittore("classifica.csv");
        ArrayList<String> posString = new ArrayList<>();
                
        for (int i = 0; i < classifica.size(); i++) {
        posString.add(classifica.get(i).Stampa(i));
        }   
                      
        scrittore.setDati(posString);
        scrittore.setCircuito(circuito.getNazione());
        scrittore.start();
        
        try {
           scrittore.join();
        }catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
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
        
        public int getMaxsPits() {
        return maxPits;
        }
        
        }
        
       
