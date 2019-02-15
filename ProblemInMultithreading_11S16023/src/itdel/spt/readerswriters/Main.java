/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.spt.readerswriters;

/**
 *
 * @author JHON LIMBONG
 */
public class Main {
    static SynchronizedDatabase RW = new SynchronizedDatabase();
    
    public static void main(String[] arg){
        int rounds = 10;
        
        new Reader(rounds, RW).start();
        new Reader(rounds, RW).start();
        new Writer(rounds, RW).start();
        new Writer(rounds, RW).start();
    }
}
