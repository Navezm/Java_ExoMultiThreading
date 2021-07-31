package com.company;

public class Playlist {

    private boolean playing = true;

    private final String[] arraySongs = new String[]{
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



    public void launch() {
        int i = 0;
        while (playing) {
            try {
                Thread.sleep(3000);
                System.out.println("NOW PLAYING -> " + arraySongs[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i > 9) {
                i = 0;
            }
        }
    }

}
