package com.augustoaccorsi.chapter3.syncronized;

class Shopper2 extends Thread{
    static int garlicCount = 0;

    private static synchronized void addGarlic(){
        garlicCount++;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10_000_000; i++)
            addGarlic();
    }
}

public class SyncronizedMethodDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper2();
        Thread olivia = new Shopper2();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy "+ Shopper2.garlicCount+" garlic");
    }
}
