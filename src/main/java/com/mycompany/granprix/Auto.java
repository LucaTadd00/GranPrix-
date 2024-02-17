package com.mycompany.granprix;

import java.io.*;
import static java.lang.Thread.sleep;
import java.util.*;

public class Auto extends Thread{
    
	private String marca;
	private String modello;
	private Partecipante proprietario;
	private int numero;
        private boolean running = true;
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
                this.truccata = random.nextInt(10);
	}
        
        public int getNumero() {
            return this.numero;
        }
        
        public boolean getRunning() {
          return running;
       }
        
        @Override
public void run() {
    Random random = new Random();
    int giri = 1;
    int ran = 0;
    boolean pit = false;
    int npit = 0;
    int giroPit = 0;
    
    while (running) {
        // Controlla se è necessario incrementare il numero di giri
        if (percentuale >= gara.getCircuito().getLunghezza() * giri) {
            giri++;
        }
        
        // Controlla se l'auto è danneggiata
        if (!damage) {
            // Controlla se la safety car è in pista
            if (!gara.getGestore().getSafetyCar()) {
                // Controlla se è necessario fare un pit stop
                if (giri >= giroPit + 2 && npit < gara.getMaxsPits()) {
                    ran = random.nextInt(70);
                    if (ran == 1) { 
                        pit = true;
                        npit++;
                        giroPit = giri;
                    }                    
                }
                
                // Simula il progresso dell'auto
                    // Applica il vantaggio di velocità per le auto truccate
            if(truccata == 1) {
              percentuale = percentuale + random.nextInt(50, 60);
           } else {
              percentuale = percentuale + random.nextInt(45, 55);
           }
                    
                    // Controlla se l'auto ha completato la gara
                    if (percentuale >= gara.getCircuito().getLunghezza() * gara.getnGiri()) {
                        running = false;
                    }
                    
                    // Simula il danneggiamento dell'auto
                    if (random.nextInt(500) == 1) {
                        damage = true;
                        running = false;
                        System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " si è RITIRATO per problemi e ha percorso: " +
            percentuale + " metri, di : " + gara.getCircuito().getLunghezza()*gara.getnGiri() + " del giro :" + giri + " e provoca un ingresso momentaneo della safety car...");
                    }
                    
                    // Stampa lo stato dell'auto
                    if (truccata == 1) {
                        System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " ha percorso: " 
                            + percentuale + " metri di : " + gara.getCircuito().getLunghezza()*gara.getnGiri() + ", del giro :" + giri + " (l'auto è truccata)");
                    } else {
                        System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " ha percorso: " 
                            + percentuale + " metri di : " + gara.getCircuito().getLunghezza()*gara.getnGiri() + ", del giro :" + giri);
                    }
                }
                     if (pit) {
                // Simula il pit stop durante la safety car
                int secpit = 0;
                while (secpit < 10) {
                    System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " è sta facendo il PITSTOP al giro: " + giri);
                    secpit++;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pit = false;
            }
        }
        
        // Simula il progresso dell'auto durante la safety car
        if (gara.getGestore().getSafetyCar() && !damage) {
            percentuale += 10;
            System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " ha percorso: " 
                            + percentuale + " metri, di : " + gara.getCircuito().getLunghezza()*gara.getnGiri() + ", del giro : " + giri + ", LA SAFETY CAR è IN PISTA");
        }
        
        // Stampa il danneggiamento dell'auto
        
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
         clearScreen();
    }
    if(!running){
    System.out.println("L'auto Numero: " + numero + ", con pilota : " + proprietario.getPilota() + " ha concluso la sua gara");
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
    
    public void setGara(Gara gara) {
    this.gara = gara;
    } 
    
    public String Stampa(int i) {
        if (damage == false) {
            return (i + 1) + "° Posizione: pilota : " + proprietario.getPilota() + " con L'auto Numero: " + proprietario.getN();         
        } else {
            return "pilota : " + proprietario.getPilota() + " con L'auto Numero: " + proprietario.getN() + " = RITIRATO";
        }
}
}
        


