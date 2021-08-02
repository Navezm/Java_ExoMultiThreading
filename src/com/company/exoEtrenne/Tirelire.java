package com.company.exoEtrenne;

import java.util.List;

public class Tirelire {

    public static int solde = 0;
    public static int nbrEtrenneRecue = 0;

    List<Etrennes> listEtrennes = null;

    public int getSolde() {
        return solde;
    }

    public static void setSolde(int solde) {
        Tirelire.solde += solde;
    }

    public int getNbrEtrenneRecue() {
        return nbrEtrenneRecue;
    }

    public static void setNbrEtrenneRecue(int nbrEtrenneRecue) {
        Tirelire.nbrEtrenneRecue += nbrEtrenneRecue;
    }

    public List<Etrennes> getListEtrennes() {
        return listEtrennes;
    }

    public void setListEtrennes(List<Etrennes> listEtrennes) {
        this.listEtrennes = listEtrennes;
    }

}
