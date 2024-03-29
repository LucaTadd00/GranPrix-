package com.mycompany.granprix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;


public class Scrittore extends Thread{

    private String nomeFile;
    private ArrayList<String> dati;
    private String circuito;
    int check;
    int check2;
    int id;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
        this.check = 0;
        this.check2 = 0; 
        this.id = 1;
        
    }
    
    //METODO RUN NON UTILIZZATO, NON UTILIZZO QUESTA CLASSE COME THREAD
    @Override
    public void run() {
        scriviClassifica();
    }

    //METODO PER LA SCRITTURA DA FILE, UTILIZZATO PER L'ISSUE 1
    
    public void scrivi(String user, String pass){
try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile, true))) {
            if (check == 0) {
                
              try (BufferedWriter bc = new BufferedWriter(new FileWriter(nomeFile))) {
              bc.write("");
              bc.flush();
              } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            } 
         }

            br.write(user);
            br.write(";");
            br.write(pass);
            br.write("\n\r");

            br.flush();
            check++;
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        }
    
    public void scriviClassifica(){
try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile, true))) {
            if (check2 == 0) {
                
              try (BufferedWriter bc = new BufferedWriter(new FileWriter(nomeFile))) {
              bc.write("");
              bc.flush();
              } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            } 
         }
            br.write("GRAN PREMIO DI " + circuito.toUpperCase() + " CLASSIFICA:");
            br.write("\n\r");
        for(int i = 0; i < dati.size(); i++) {
            br.write(dati.get(i));
            br.write("\n\r");

        }
            br.flush();
            check2++;
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        }
    
    //METODO PER LA SCRITTURA IN FILE UTILIZZANDO DATAOUTPUTSTREAM, UTILIZZATO PER L'ISSUE 3
    
     public void scriviCSV(String[] elementi) {
        /* utilizzando la classe DataOutputStream */
        try (DataOutputStream scrittore = new DataOutputStream(new FileOutputStream(nomeFile, true))){
            
             if (id == 1) {
               try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(nomeFile))) {
                ds.writeUTF("");
                ds.flush();
               } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
             String idSt = Integer.toString(id);
            scrittore.writeUTF(idSt);
            scrittore.writeUTF(";");
            for (String elemento : elementi) {
                scrittore.writeUTF(elemento);
                scrittore.writeUTF(";");
            }
            scrittore.writeUTF("\n");
            id = id + 1;
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void setDati(ArrayList<String> dati) {
     this.dati = dati;
     }
     
     public void setCircuito(String circuito) {
     this.circuito = circuito;
     }
    }
