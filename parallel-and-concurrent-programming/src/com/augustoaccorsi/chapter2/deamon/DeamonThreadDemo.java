package com.augustoaccorsi.chapter2.deamon;

class KitchenCleaner extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("Olivia cleaned the kitchen.");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }
}

public class DeamonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread olivia = new KitchenCleaner();
        olivia.setDaemon(true);
        olivia.start();

        System.out.println("Barron is cooking...");
        Thread.sleep(600);
        System.out.println("Barron is cooking...");
        Thread.sleep(600);
        System.out.println("Barron is cooking...");
        Thread.sleep(600);
        System.out.println("Barron is done!");
    }
}
