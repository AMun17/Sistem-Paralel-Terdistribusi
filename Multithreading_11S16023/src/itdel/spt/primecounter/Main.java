/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.spt.primecounter;

import itdel.spt.utils.Stopwatch;

/**
 *
 * @author JHON LIMBONG
 */
public class Main {
    public static void main(String _args[]){
        Stopwatch stopwatch = new Stopwatch();
        long elapsedTime = 0L;
        long min = 0L;
        long max = 1000000L;
        PrimeCounter pc = new PrimeCounter(min, max);
        
        stopwatch.record();
        pc.count();
        elapsedTime = stopwatch.capture();
        System.out.printf("finished in %d sec(s)\n", elapsedTime);
    }
}
