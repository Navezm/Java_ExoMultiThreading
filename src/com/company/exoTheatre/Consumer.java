package com.company.exoTheatre;

public class Consumer extends Thread {

    private String name;
    private Caract type;

    private enum Caract {
        BAVARD,
        NORMAL,
        TACITURNE
    }



}
