package com.augustoaccorsi.chapter2.thread;

class CPUWaster extends Thread{
    public void run() {
        while(true){}
    }
}

public class ThreadProcessDemo {
    public static void main(String[] args) throws InterruptedException{

        Runtime runtime = Runtime.getRuntime();
        long usedKB = (runtime.totalMemory() - runtime.freeMemory()) / 1024 ;
        System.out.println("Process ID: "+ProcessHandle.current().pid());
        System.out.println("Thread Count: "+ Thread.activeCount());
        System.out.println("Memory Usage: "+usedKB+"KB");

        // start 6 new threads
        System.out.println("\nStarting 6 CPUWaster threads...\n");
        for (int i=0; i<6; i++)
            new CPUWaster().start();

        // display current information about this process
        usedKB = (runtime.totalMemory() - runtime.freeMemory()) / 1024 ;
        System.out.println("Process ID: "+ProcessHandle.current().pid());
        System.out.println("Thread Count: "+ Thread.activeCount());
        System.out.println("Memory Usage: "+usedKB+"KB");
    }
}
