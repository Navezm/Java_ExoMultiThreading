package com.company;

import java.util.Scanner;

public class Main {

    static int index = 0;

    public static void main(String[] args) {

        Thread playlist = new Thread(play());

        playlist.start();

        boolean boucle = true;

        do {
            String command = new Scanner(System.in).nextLine();

            System.out.println(command);
            switch (command) {
                case "reset":
                    playlist.interrupt();
                    index = 0;
                    playlist = new Thread(play());
                    playlist.start();
                    break;
                case "pause":
                    playlist.interrupt();
                    break;
                case "play":
                    playlist = new Thread(play());
                    playlist.start();
                    break;
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
}
