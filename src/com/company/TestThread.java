package com.company;

public class TestThread {


    static int compteur = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                decrement();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(compteur);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void increment(){
        synchronized (lock) {
            compteur++;
        }
    }

    public static void decrement() {
        synchronized (lock){
            compteur--;
        }
    }

//    Autre manière de faire :
//    public synchronized static void increment(){
//        synchronized (lock) {
//            compteur++;
//        }
//    }
//
//    public synchronized static void decrement() {
//        synchronized (lock){
//            compteur--;
//        }
//    }

}
