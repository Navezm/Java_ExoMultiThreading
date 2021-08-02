package com.company.exoPlaylist;

import java.util.Scanner;

public class Main {

    static int index = 0;

    public static void main(String[] args) {

        Thread playlist = new Thread(play());

        playlist.start();

        boolean boucle = true;

        do {
            String command = new Scanner(System.in).nextLine();

            switch (command) {
                case "reset":
                    index = 0;
                    break;
                case "pause":
                    playlist.interrupt();
                    break;
                case "play":
                    if (playlist.getState() == Thread.State.TERMINATED) {
                        playlist = new Thread(play());
                        playlist.start();
                    } else {
                        System.out.println("Il faut pause avant play");
                    }
                    break;
                default:
                case "stop":
                    playlist.interrupt();
                    boucle = false;
                    break;
            }
        } while (boucle);

    }

    public static Runnable play(){
        return () -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("NOW PLAYING -> " + Playlist.arraySongs[index]);
                } catch (InterruptedException e) {
                    index--;
                    return;
                }
                index++;
                if (index > 9) {
                    index = 0;
                }
            }
        };
    }

    static void action() {
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println("NOW PLAYING -> " + Playlist.arraySongs[index]);
            } catch (InterruptedException e) {
                index--;
                return;
            }
            index++;
            if (index > 9) {
                index = 0;
            }
        }
    }
}
