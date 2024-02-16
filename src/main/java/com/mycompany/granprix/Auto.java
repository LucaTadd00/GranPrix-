package com.mycompany.granprix;

import java.io.*;
import java.util.*;

public class Auto extends Thread{
    
	private String marca;
	private String modello;
	private Partecipante proprietario;
	private int numero;
        private boolean running;
        private boolean damage = false;
        private int truccata;
        private int percentuale = 0;
        private Gara gara;
        private boolean saved = false;

	public Auto(String modello, String marca, int numero, Partecipante p) {
		this.modello = modello;
                this.marca = marca;
                this.numero = numero;
                this.proprietario = p;
                Random random = new Random();
                this.truccata = random.nextInt(3);
	}
        
        public int getNumero() {
            return this.numero;
        }
        
        public boolean getRunning() {
          return running;
       }
        
        @Override
        public void run(){
    Random random = new Random();
    int giri = 0;
    int ran = 0;
    boolean pit = false;
    
    
    while (running) {
        if(!damage) {
            if(gara.getGestore().getSafetyCar() == false) {
                if (giri >= 5) {
                    ran = random.nextInt(10);
                    if (ran == 1) { 
                    pit = true;
                    }                    
                }
                
                if (!true) {
           if(truccata == 1) {
              percentuale = percentuale + random.nextInt(50, 60);
           } else {
              percentuale = percentuale + random.nextInt(45, 55);
           }
       
      if (percentuale >= gara.getCircuito().getLungezza() * gara.getnGiri()) {
        running = false;
        
      }

      int danni = random.nextInt(250);
      if (danni == 1) {
        damage = true;
      }
      
      if(truccata == 1) {
              System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " sta alla percentuale: " 
              + (int)(gara.getCircuito().getLungezza()*(percentuale/100.0f)) + "% del giro :" + gara.getnGiri() + " (l'auto è truccata)");
           } else {
              System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " sta alla percentuale: " 
              + (int)(gara.getCircuito().getLungezza()*(percentuale/100.0f)) + "% del giro :" + gara.getnGiri());
           }

            } else {
            System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " è sta facendo il PITSTOP");
            }
        if(gara.getGestore().getSafetyCar() == true) {
        percentuale = percentuale + 10;
        System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " sta alla percentuale: " 
              + (int)(gara.getCircuito().getLungezza()*(percentuale/100.0f)) + "% del giro :" + gara.getnGiri());
        }
        } 
        if (damage) {
        System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " si è ROTTA alla percentuale: " +
                (int)(gara.getCircuito().getLungezza()*(percentuale/100.0f)) + "% del giro :" + gara.getnGiri() + "e provoca un ingresso momentaneo della safety car...");
        }
        
        giri = giri + 1;
        
        
     
      try {
        sleep(500);
      } catch (InterruptedException e) {
      }
      
      clearScreen();
        }

    }
    }
        
    public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    
  }
    
    public boolean getDamage() {
    return damage;
    }
    
    public int getPercentuale() {
    return percentuale;
    }
    
    public boolean getSaved() {
    return saved;
    }  
    
    public void setSaved(boolean saved) {
    this.saved = saved;
    } 
    
    public Partecipante getProprietario() {
    return proprietario;
    }
    
    public String Stampa(int i) {
            return i + "° Posizione: pilota : " + proprietario.getPilota() + " con L'auto Numero: " + proprietario.getN();         
        }
}
        


