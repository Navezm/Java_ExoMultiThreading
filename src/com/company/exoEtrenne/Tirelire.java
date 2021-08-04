package com.company.exoEtrenne;

import java.util.ArrayList;
import java.util.List;

public class Tirelire {

    public static int solde = 0;
    public static int nbrEtrenneRecue = 0;

    public static List<Etrennes> listEtrennes = new ArrayList<>();

    public int getSolde() {
        return solde;
    }

    public synchronized static void setSolde(int solde) {
        Tirelire.solde += solde;
    }

    public int getNbrEtrenneRecue() {
        return nbrEtrenneRecue;
    }

    public synchronized static void setNbrEtrenneRecue() {
        Tirelire.nbrEtrenneRecue += 1;
    }

    public static List<Etrennes> getListEtrennes() {
        return listEtrennes;
    }

    public static void setListEtrennes(Etrennes etrennes) {
        Tirelire.listEtrennes.add(etrennes);
    }

}
