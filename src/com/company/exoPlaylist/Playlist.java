package com.company.exoPlaylist;

public class Playlist implements Runnable {

    private int index = 0;

    public static String[] arraySongs = new String[]{
            "Wonderful Life - Simth & Burrows",
            "Iota - Killstation",
            "We Did It!! - Grandson",
            "MONTERO - Lil Nas X",
            "Drink I'm Sippin On - Yaeji",
            "The Story - Conan Gray",
            "Y.A.S. - Todrick Hall",
            "High Hopes - Joji",
            "Go Solo - Tom Rosenthal",
            "We - Bon Iver"
    };

    @Override
    public void run() {
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
