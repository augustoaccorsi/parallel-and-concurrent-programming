package com.augustoaccorsi.chapter3.mutex;

import java.util.concurrent.locks.*;

class Shopper extends Thread{
    static int garlicCount = 0;
    static Lock pencil = new ReentrantLock();

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            pencil.lock();
            garlicCount++;
            pencil.unlock();
            System.out.println(Thread.currentThread().getName()+" is thinking.");
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }
}

public class MutualExclusionDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper();
        Thread olivia = new Shopper();
        barron.setName("Barron");
        olivia.setName("Olivia");
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy "+ Shopper.garlicCount+" garlic");
    }
}
