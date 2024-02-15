package GranP.GranPrix;

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

       System.out.println("Gran Prix Login!");
        System.out.println("inserisci l'username : ");
        String userName = s.nextLine().toUpperCase();
        System.out.println("inserisci la password : ");
        String password = s.nextLine().toUpperCase();
        
        String criptedPass = matrix.cifra(password);
            
        scrittore.scrivi(userName, criptedPass);
        
        System.out.println("Login riuscito! ora le tue credenziali sono salvate nel file 'output.csv'.");
        
        System.out.println("username : " + userName);
        System.out.println("password criptata: " + criptedPass);
      int choise = 8;
      while(choise != 7) {  
          
         System.out.println("ora scegli un opzione : ");  
         System.out.println("1. inserisci un pilota al Gran Prix"); 
         System.out.println("2. aggiungi un auto al Gran Prix"); 
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
        System.out.println("inserisci il numero dell auto con il quale correra il partecipante :");
        int nAuto = s.nextInt();
        s.nextLine();
         for (int i = 0; i < auto.size(); i++) { 
         if (nAuto == auto.get(i).getNumero()) {
         partecipanti.add(new Partecipante(nameP, surnameP, numberP, auto.get(i)));
         }
         System.out.println("ora inserisci i valori dell'auto del partecipante :");
         System.out.println("inserisci il nome del partecipante (pilota) :");
         String nameP = s.nextLine();
         System.out.println("inserisci il nome del partecipante (pilota) :");
         String nameP = s.nextLine();
         System.out.println("inserisci il nome del partecipante (pilota) :");
         String nameP = s.nextLine();
         }
    break;
  case 2:

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
