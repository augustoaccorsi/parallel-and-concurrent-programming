package com.augustoaccorsi.chapter2.scheduling;

class VegetableChopper extends Thread{
    public int vegetableCount = 0;
    public static boolean chopping = true;

    public VegetableChopper(String name){
        this.setName(name);
    }

    public int getVegetableCount() {
        return vegetableCount;
    }

    @Override
    public void run() {
        while(chopping){
            System.out.println(this.getName()+" chopped a vegetable!");
            this.vegetableCount++;
        }
    }
}

public class SchedulingDemo {
    public static void main(String[] args) throws InterruptedException {
        VegetableChopper guto = new VegetableChopper("Guto");
        VegetableChopper daia = new VegetableChopper("Daia");

        guto.start();
        daia.start();
        Thread.sleep(1000);
        VegetableChopper.chopping = false;

        guto.join();
        daia.join();

        System.out.format("Guto chopped %d vegetables.\n", guto.getVegetableCount());
        System.out.format("Daia chopped %d vegetables.\n", daia.getVegetableCount());
    }
}
