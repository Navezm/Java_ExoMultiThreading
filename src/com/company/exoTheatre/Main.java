package com.company.exoTheatre;

public class Main {

    public static void main(String[] args) {

        SentenceQueue sQ = new SentenceQueue();
        ThreadGroup group = new ThreadGroup("Group 1");

        Producer prod1 = new Producer("Prod 1", sQ, group);
        Producer prod2 = new Producer("Prod 2", sQ, group);
        Producer prod3 = new Producer("Prod 3", sQ, group);

        Consumer cons1 = new Consumer(sQ, "Actor 1", group);
        Consumer cons2 = new Consumer(sQ, "Actor 2", group);
        Consumer cons3 = new Consumer(sQ, "Actor 3", group);

        prod1.start();
        prod2.start();
        prod3.start();

        cons1.start();
        cons2.start();
        cons3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group.interrupt();

    }

}
