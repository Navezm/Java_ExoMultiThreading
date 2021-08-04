package com.company.exoTheatre;

import java.util.Random;

public class Producer extends Thread {

    private final SentenceQueue sentence;
    private static final Object lock = new Object();

    private String[] sujet = {
            "Le soleil",
            "La route",
            "Le jeudi",
            "La folie",
            "L'erreur",
            "Le micro",
            "La fantaisie",
            "Le chien",
            "La poule",
            "Le territoire"
    };

    private String[] verbe = {
            "mange",
            "roule",
            "boit",
            "pleut",
            "vit",
            "choisit",
            "rougis",
            "cours",
            "sieste",
            "prie"
    };

    private String[] adjectif = {
            "joli",
            "chaleureux",
            "jovial",
            "bourru",
            "éclatant",
            "resplendissant",
            "morose",
            "coloré",
            "ensoleilé",
            "fatigué"
    };

    private String[] complement = {
            "de bon matin",
            "sans chapeau",
            "sa misère",
            "la leçon des streams",
            "le claquement du genou",
            "la petite maison arrière",
            "l'apprentissage de Java",
            "la sérénade",
            "le petit coquelicot",
            "dans la maison de son père"
    };

    public Producer(String name, SentenceQueue sentence) {
        super(name);
        this.sentence = sentence;
    }

    public String createSentence() {
        Random rand = new Random();
        return sujet[rand.nextInt(10)] + " " + adjectif[rand.nextInt(10)] + " " + verbe[rand.nextInt(10)] + " " + complement[rand.nextInt(10)];
    };

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            synchronized (lock) {
                this.sentence.add(createSentence());
                System.out.println(Thread.currentThread().getName() + " a ajouté une phrase");
            }
        }
    }
}
