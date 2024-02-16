
package com.mycompany.granprix;

import java.util.Random;

/**
 *
 * @author asuf507zu4lp054w
 */
public class GestoreGara extends Thread{
    
    private String nome;
    private Gara gara;
    private boolean safetyCar = false;
    
    public GestoreGara(String nome) {
        this.nome = nome;
    }
    
    public void run() {
        int problem;
        Random random = new Random();
    while (true) {
     for (int i = 1; i < gara.getnAuto().size(); i++) {
         if(gara.getnAuto().get(i).getDamage()) {
         safetyCar = true;
       try {
        sleep(1500);
      } catch (InterruptedException e) {
      }
       safetyCar = false;
         }
     }
        
    problem = random.nextInt(100);
    if (problem == 1) {
    safetyCar = true;
    try {
        sleep(1500);
      } catch (InterruptedException e) {
      }
       safetyCar = false;
    }
     try {
        sleep(200);
      } catch (InterruptedException e) {
      }
    }
    }
    
    public boolean getSafetyCar(){
    return safetyCar;
    }
    
    public void setGara(Gara gara) {
    this.gara = gara;
    }
    
    
}
