package com.dandy1988;

import java.util.Scanner;

public class MenuPlayer {
    public static void work() {
        Player mediaAll = new Player();
        String choice = "";
        System.out.println("");
        System.out.println("This is interactive multi media player");
        System.out.println("1- add new song, 2- list of songs in the player, 3 - play song, 4 - play all songs, 5 - add song after song name = , 6 - delete song name =, 7- exit");

        Scanner sc1 = new Scanner(System.in);

        while (!(choice.equals("7"))) {
            sc1.reset();
            System.out.println();
            System.out.print("Input your choice = ");
            choice = sc1.nextLine();

            switch (choice) {
                case "1": {
                    mediaAll.songNew();
                    sc1.reset();
                    break;
                }

                case "2": {
                    mediaAll.outputListOfSong();
                    sc1.reset();
                    break;
                }

                case "3": {
                    mediaAll.playSong();
                    sc1.reset();
                    break;
                }

                case "4": {
                    //TODO
                    sc1.reset();
                    break;
                }

                case "5": {
                    mediaAll.findSongAndAdd();
                    sc1.reset();
                    break;
                }

                case "6": {
                    mediaAll.deleteSong();
                    sc1.reset();
                    break;
                }

                case "7": {
                    sc1.reset();
                    break;
                }
            }
        }
        sc1.reset();
    }
}

