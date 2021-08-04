package com.company.exoEtrenne;

import java.util.Random;

public class Etrennes implements Runnable {

    Random rand = new Random();

    private final int quantiteArgent;
    private final int interval;
    private boolean enCours = true;
    private int id;
    private static int nbEtrennes = -1;

    public Etrennes() {
        this.quantiteArgent = rand.nextInt(51) + 15;
        this.interval = rand.nextInt(10001) + 3000;
        Tirelire.setListEtrennes(this);
        nbEtrennes += 1;
        this.setId(nbEtrennes);
    }

    public Etrennes(int quantiteArgent, int interval) {
        this.quantiteArgent = quantiteArgent;
        this.interval = interval;
        Tirelire.setListEtrennes(this);
        nbEtrennes += 1;
        this.setId(nbEtrennes);
    }

    public int getQuantiteArgent() {
        return quantiteArgent;
    }

    public int getInterval() {
        return interval;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Etrennes{" +
                "Argent = " + quantiteArgent +
                ", Récurence = " + interval +
                ", En cours = " + enCours +
                ", ID = " + id +
                '}';
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(this.getInterval());
                Tirelire.setSolde(this.getQuantiteArgent());
                Tirelire.setNbrEtrenneRecue();
//                System.out.println(this.getQuantiteArgent() + "€ ont été rajouté à la tirelire");
            }
        } catch (InterruptedException e) {
            this.enCours = false;
            return;
        }
    }
}
