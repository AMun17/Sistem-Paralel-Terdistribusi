/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.spt.readerswriters;

import java.util.Random;

/**
 *
 * @author JHON LIMBONG
 */
public class SynchronizedDatabase {
    private Random generator = new Random();
    private int data = 0; // the 'database'
    int nr = 0;
    
    private synchronized void startRead(){
        nr++;
    }
    
    private synchronized void endRead(){
        nr--;
        if(nr == 0) 
            notify();   // awaken waiting Writers
    }
    
    public void read(){
        startRead();
        System.out.println("read: " + data);
        endRead();
    }
    
    public synchronized void write(){
        int temp;
        while(nr > 0)
            try{
                wait();
            }catch(InterruptedException ex){
                return;
            }
       
        temp = data;
        data = 99999; // to simulate an inconsistent temporary state
        
        try{
            Thread.sleep(generator.nextInt(500)); //wait a bit
        }catch(java.lang.InterruptedException e){}
        
        data = temp + 1;    // back to a safe state
        System.out.println("wrote: " + data);
        notify();
    }
}
