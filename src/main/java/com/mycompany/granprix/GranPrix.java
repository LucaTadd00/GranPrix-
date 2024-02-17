package com.mycompany.granprix;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author asuf507zu4lp054w
 */
public class GranPrix {
    
    private static Matrice matrix;
        
    public static void main(String[] args) {
      
Scanner s = new Scanner(System.in);
Lettore lettore = new Lettore("output.csv");
Scrittore scrittore = new Scrittore("output.csv");
ArrayList<Auto> auto = new ArrayList<>();
ArrayList<Partecipante> partecipanti = new ArrayList<>();
Circuito circuito = new Circuito();
int maxPits = 0;
int nGiri = 0;
matrixBuilder();


       System.out.println("Gran Prix Login!");
        System.out.println("inserisci l'username : ");
        String userName = s.nextLine().toUpperCase();
        System.out.println("inserisci la password : ");
        String password = s.nextLine().toUpperCase();
        
        String criptedPass = matrix.cifra(password);
            
        scrittore.scrivi(userName, criptedPass);
        
        System.out.println("Login riuscito! ora le tue credenziali sono salvate nel file 'output.csv'.");
        
        int choise1 = 0;  
          
         System.out.println("ora scegli un opzione : "); 
         System.out.println("1. crea un gran prix"); 
         System.out.println("2. stampa i risultati della gara piu recente"); 
         System.out.println("3. effettua il logout"); 
                 
         choise1 = s.nextInt();
         s.nextLine();
  
        try {     
        switch(choise1) {
  case 1:

      System.out.println("Iniziamo con la creazione! ora inserisci le specifiche del GranPrix");
      System.out.println("inserisci il nome del circuito");
      String nCircuito = s.nextLine();
      System.out.println("inserisci la lunghezza del circuito");
      double lCircuito = s.nextDouble();
      s.nextLine();
      System.out.println("inserisci la nazione in cui risiede il circuito");
      String naCircuito = s.nextLine();
      
      circuito = new Circuito(naCircuito, lCircuito, nCircuito);
         
      System.out.println("inserisci il numero massimo di pit stop");
      maxPits = s.nextInt();
      s.nextLine();
      System.out.println("inserisci il numero di giri");
      nGiri = s.nextInt();
      s.nextLine();
      
    break;
  case 2:

    break;
  case 3:
      System.out.println("disconnessione in corso...");
      try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
      break;
      default:
    System.out.println("scelta inesistente o non corretta"); 
}
    } catch (InputMismatchException e) { 
    System.err.println("Errore: Input non numerico. Assicurati di inserire un numero valido.");
    choise1 = 0;
    s.nextLine();
    }    

      int choise = 8;
int remember = 0;
if(choise1 == 1) {
      while(choise != 7) {  
          
         System.out.println("ora scegli un opzione : "); 
         System.out.println("1. aggiungi un pilota e la sua auto al granprix al Gran Prix"); 
         System.out.println("2. inizia la gara"); 
                 
         choise = s.nextInt();
         s.nextLine();
  
        try {     
        switch(choise) {
  case 1:
        System.out.println("inserisci il nome del partecipante (pilota) :");
        String nameP = s.nextLine();
        System.out.println("inserisci il cognome del partecipante :");
        String surnameP = s.nextLine();
        System.out.println("inserisci il numero del partecipante :");
        int numberP = s.nextInt();
        s.nextLine();

        partecipanti.add(new Partecipante(nameP, surnameP, numberP));

        System.out.println("ora inserisci le specifiche dell'auto del partecipante :");
        System.out.println("inserisci il modello dell'auto :");
        String modello = s.nextLine();
        System.out.println("inserisci la marca dell auto :");
        String marca = s.nextLine();

        auto.add(new Auto(modello, marca, numberP, partecipanti.get(remember)));
        partecipanti.get(remember).setAuto(auto.get(remember));

        remember = remember + 1;
    break;
  case 2:
      

      GestoreGara gestore = new GestoreGara("paolo bonolis");
      Gara granPrix = new Gara(circuito, maxPits, nGiri, auto, partecipanti, gestore);
      gestore.setGara(granPrix);
      for (int i = 0; i < auto.size(); i++) {
            auto.get(i).setGara(granPrix);           
        }
            
      gestore.start();
      granPrix.start();
      
      try{
            granPrix.join();
        }catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } 
      
      gestore.stopGestore();
      

    break;
  case 3:
      System.out.println("uscita in corso..."); 
    try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
      break;
      default:
    System.out.println("scelta inesistente o non corretta"); 
}
    } catch (InputMismatchException e) { 
    System.err.println("Errore: Input non numerico. Assicurati di inserire un numero valido.");
    choise = 0;
    s.nextLine();
    }
}
}
    }

    
    
    
    public static void matrixBuilder() {
    String key = "GRANPRIX";
    matrix = new Matrice(key);    
    ArrayList<Vigenere> quadranti = new ArrayList<>();
    Vigenere quadrante_1=new Vigenere(0,12,0,12,matrix);
     quadranti.add(quadrante_1);
    
    Vigenere quadrante_2=new Vigenere(0,12,12,26,matrix);
     quadranti.add(quadrante_2);
    
    Vigenere quadrante_3=new Vigenere(12,26,0,12,matrix);
     quadranti.add(quadrante_3);
    
    Vigenere quadrante_4=new Vigenere(12,26,12,26,matrix);
    quadranti.add(quadrante_4);
        
        for (Vigenere v : quadranti) {
          Thread t = new Thread(v);
          t.start();
          try {
              t.join();
          } catch (InterruptedException ex) {
              System.err.println("Errore metodo join");
          }
        }
}
}
