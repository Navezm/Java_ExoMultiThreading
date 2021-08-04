package com.company.exoEtrenne;

import java.util.Random;

public class Etrennes implements Runnable {

    Random rand = new Random();

    private int quantiteArgent;
    private int interval;
    private boolean enCours = true;

    public Etrennes() {
        this.quantiteArgent = rand.nextInt(51) + 15;
        this.interval = rand.nextInt(10001) + 3000;
        Tirelire.setListEtrennes(this);
    }

    public Etrennes(int quantiteArgent, int interval) {
        this.quantiteArgent = quantiteArgent;
        this.interval = interval;
        Tirelire.setListEtrennes(this);
    }

    public int getQuantiteArgent() {
        return quantiteArgent;
    }

    public int getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "Etrennes{" +
                "Argent = " + quantiteArgent +
                ", Récurence = " + interval +
                ", En cours = " + enCours +
                '}';
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(this.getInterval());
                Tirelire.setSolde(this.getQuantiteArgent());
                Tirelire.setNbrEtrenneRecue();
                System.out.println(this.getQuantiteArgent() + "€ ont été rajouté à la tirelire");
            }
        } catch (InterruptedException e) {
            this.enCours = false;
            return;
        }
    }
}
