package com.company.exoTheatre;

public class Main {

    public static void main(String[] args) {

        SentenceQueue sQ = new SentenceQueue();

        Producer prod1 = new Producer("Prod 1", sQ);
        Producer prod2 = new Producer("Prod 2", sQ);
        Producer prod3 = new Producer("Prod 3", sQ);

        Consumer cons1 = new Consumer(sQ, "Actor 1");
        Consumer cons2 = new Consumer(sQ, "Actor 2");
        Consumer cons3 = new Consumer(sQ, "Actor 3");

        prod1.start();
        prod2.start();
        prod3.start();

        cons1.start();
        cons2.start();
        cons3.start();

    }

}
