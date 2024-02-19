
package com.mycompany.granprix;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author asuf507zu4lp054w
 */
public class GestoreGara extends Thread{
    
    private String nome;
    private Gara gara;
    private boolean safetyCar = false;
    private boolean running = true;
    
    public GestoreGara(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void run() {
        running = true;
        int problem;
        Random random = new Random();
    while (running) {
     for (int i = 0; i < gara.getnAuto().size(); i++) {
         if(gara.getnAuto().get(i).getDamage()) {
         safetyCar = true;
       try {
        sleep(10000);
      } catch (InterruptedException e) {
      }
       safetyCar = false;
         }
     }
        
    problem = random.nextInt(300);
    if (problem == 1) {
    safetyCar = true;
    try {
        sleep(10000);
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
    
    public void stopGestore() {
    running = false;
    }
    
    
}
