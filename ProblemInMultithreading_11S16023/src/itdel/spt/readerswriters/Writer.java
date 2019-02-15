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
public class Writer extends Thread{
    int rounds;
    SynchronizedDatabase RW;
    private Random generator = new Random();
    
    public Writer(int _rounds, SynchronizedDatabase _RW){
        this.rounds = _rounds;
        this.RW = _RW;
    }
    
    @Override
    public void run(){
        for(int count = 0; count < rounds; ++count){
            try{
                Thread.sleep(generator.nextInt(500));
            }catch(java.lang.InterruptedException e){}
            RW.write();
        }
    }
}
