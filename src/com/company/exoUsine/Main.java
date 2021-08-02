package com.company.exoUsine;

public class Main {

    public static void main(String[] args) {
        Factory.createCar("red", "B42DFRT", 90.00);
        Factory.createCar("yellow", "B4D244FT", 52.00);
        Factory.createCar("blue", "545TRFD", 63.00);
        Factory.createCar("black", "98774NCHBS", 74.00);
        Factory.createCar("grey", "00082NC", 110.00);

        Thread n = new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println(Factory.carList.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        n.start();
    }

}
