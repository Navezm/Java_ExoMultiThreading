package com.company.exoEtrenne;

import java.util.Random;

public class Etrennes implements Runnable {

    Random rand = new Random();

    private int quantiteArgent = rand.nextInt(51) + 15;
    private int interval = rand.nextInt(10001) + 3000;

    public int getQuantiteArgent() {
        return quantiteArgent;
    }

    public int getInterval() {
        return interval;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.getInterval());
            Tirelire.setSolde(this.getQuantiteArgent());
            Tirelire.setNbrEtrenneRecue(1);
            System.out.println(this.getQuantiteArgent() + " a été rajouté à la tirelire");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
