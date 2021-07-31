package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Thread playlist = new Thread(() -> {
            boolean playing = true;
            int index = 0;
            while (playing) {
                try {
                    Thread.sleep(5000);
                    System.out.println("NOW PLAYING -> " + Playlist.arraySongs[index]);
                } catch (InterruptedException e) {
                    return;
                }
                index++;
                if (index > 9) {
                    index = 0;
                }
            }
        });

        playlist.start();

        String command = new Scanner(System.in).nextLine();

        System.out.println(command);
        switch (command) {
            case "reset":

                break;
            case "pause":

                break;
            case "play":

                break;
            case "stop":
                playlist.interrupt();
                break;
        }

    }
}
