package com.company.exoEtrenne;

import java.util.Objects;
import java.util.Scanner;

public class Menu {

    public static void launch() {

        Tirelire tirelire = new Tirelire();

        Etrennes etrennes1 = new Etrennes();
        Etrennes etrennes2 = new Etrennes();

        Thread t1 = new Thread(etrennes1);
        Thread t2 = new Thread(etrennes2);

        t1.start();
        t2.start();

        Scanner scan = new Scanner(System.in);
        String cmd = "";

        do {
            System.out.println("Bienvenue dans le menu de ta tirelire ! Tu peux trouver différentes options pour intéragir avec tes étrennes et ta tirelire :");
            System.out.println("""
                    1. Vérifier la quantité d'argent
                    2. Voir les étrennes déjà en places
                    3. Ajouter une étrennes
                    4. Stopper les étrennes
                    5. Arrêter le programme
                    """);
            cmd = scan.nextLine();
            switch (cmd){
                case "1":
                    System.out.println("Tu possèdes actuellement : " + tirelire.getSolde() + "€");
                    break;
                case "2":
                    System.out.println(Tirelire.getListEtrennes());
                    System.out.println("Tu as déjà reçu " + Tirelire.nbrEtrenneRecue + " étrenne(s)");
                    break;
                case "3":
                    creerEtrenne();
                    break;
                case "4":
//                    stopperEtrennes();
                    break;
                case "5":
                    System.out.println("Le programme va s'arrêter");
//                    stopperEtrennes();
                    break;
                default:
                    System.out.println("Cette commande n'existe pas essaie encore");
                    break;
            }
        } while (!Objects.equals(cmd, "5"));
    }

    public static void creerEtrenne(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Tu peux ajouter une étrenne, il faut spécifier son montant :");
        int montant = Integer.parseInt(scan.nextLine());
        System.out.println("Maintenant la récurence en secondes :");
        int interval = Integer.parseInt(scan.nextLine() + "000");

        Etrennes newEtrenne = new Etrennes(montant, interval);
        Thread newThread = new Thread(newEtrenne);
        newThread.start();
    }
}
