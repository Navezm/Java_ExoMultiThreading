package com.company.exoTheatre;

import java.util.Random;

public class Consumer extends Thread {

    private final Caract type;
    private final SentenceQueue sentence;

    private enum Caract {
        BAVARD,
        NORMAL,
        TACITURNE
    }

    public Consumer(SentenceQueue sentence, String name) {
        super("ACTOR " + name);
        Random rand = new Random();
        this.sentence = sentence;
        Caract car;
        int type = rand.nextInt(3);
        switch (type){
            case 0:
                car = Caract.BAVARD;
                break;
            case 1:
                car = Caract.NORMAL;
                break;
            default:
            case 2:
                car = Caract.TACITURNE;
                break;
        }
        this.type = car;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            System.out.println(" ----> " + Thread.currentThread().getName() + " dit " + sentence.getSentence());
            switch (this.type){
                case NORMAL:
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    break;
                case BAVARD:
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    break;
                case TACITURNE:
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    break;
            }
        }
    }
}
