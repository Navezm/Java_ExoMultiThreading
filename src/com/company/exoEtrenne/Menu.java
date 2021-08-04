package com.company.exoEtrenne;

import java.util.Objects;
import java.util.Scanner;

public class Menu {

    public static ThreadGroup etrennesGroup = new ThreadGroup("Group1");

    public static void launch() {

        // Rajouts de deux étrennes fictives
        Etrennes etrennes1 = new Etrennes();
        Etrennes etrennes2 = new Etrennes();

        Thread t1 = new Thread(etrennesGroup, etrennes1);
        Thread t2 = new Thread(etrennesGroup, etrennes2);

        t1.start();
        t2.start();

        // Début menu
        Scanner scan = new Scanner(System.in);
        String cmd = "";

        do {
            System.out.println();
            System.out.println("Bienvenue dans le menu de ta tirelire ! Tu peux trouver différentes options pour intéragir avec tes étrennes et ta tirelire :");
            System.out.println("""
                    1. Vérifier la quantité d'argent
                    2. Voir les étrennes déjà en places
                    3. Ajouter une étrennes
                    4. Stopper les étrennes
                    5. Stopper une étrenne en particulier
                    6. Arrêter le programme
                    """);
            cmd = scan.nextLine();
            switch (cmd){
                case "1":
                    System.out.println("Tu possèdes actuellement : " + Tirelire.getSolde() + "€");
                    break;
                case "2":
                    System.out.println(Tirelire.getListEtrennes());
                    System.out.println("Tu as déjà reçu " + Tirelire.getNbrEtrenneRecue() + " étrenne(s)");
                    break;
                case "3":
                    creerEtrenne();
                    break;
                case "4":
                    stopperEtrennes();
                    break;
                case "5":
                    stopperUneEtrenne();
                    break;
                case "6":
                    System.out.println("Le programme va s'arrêter");
                    stopperEtrennes();
                    break;
                default:
                    System.out.println("Cette commande n'existe pas essaie encore");
                    break;
            }
        } while (!Objects.equals(cmd, "6"));
    }

    public static void creerEtrenne(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Tu peux ajouter une étrenne, il faut spécifier son montant :");
        int montant = Integer.parseInt(scan.nextLine());
        System.out.println("Maintenant la récurence en secondes :");
        int interval = Integer.parseInt(scan.nextLine() + "000");

        Etrennes newEtrenne = new Etrennes(montant, interval);
        Thread newThread = new Thread(etrennesGroup, newEtrenne);
        newThread.start();
    }

    public static void stopperEtrennes() {
        etrennesGroup.interrupt();
    }

    public static void stopperUneEtrenne() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Quel est l'id de l'étrenne que tu veux stopper");
        int id = Integer.parseInt(scan.nextLine());

        Thread[] allActifThread = new Thread[etrennesGroup.activeCount()];
        etrennesGroup.enumerate(allActifThread);

        if (id < allActifThread.length) {
            Thread thread = allActifThread[id];
            thread.interrupt();
            System.out.println("Le thread est correctement arrêté");
        } else {
            System.out.println("Cet ID n'existe pas ou ce Thread n'est pas actif");
        }
    }
}
