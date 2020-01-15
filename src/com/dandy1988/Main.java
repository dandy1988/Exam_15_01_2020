package com.dandy1988;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ArrayList<Media> mediaPlayer = new ArrayList<Media>() {{
            add(new Media("M. Jackson", "Billie Jean", 20));
            add(new Media("M. Jackson", "Earth Song", 15));
            add(new Media("M. Jackson", "Smooth Criminal", 25));
            add(new Media("Metallica", "Load", 30));
            add(new Media("Metallica", "The Unforgiven", 40));

        }};
        String choice = "";
        System.out.println("This is interactive multi media player");
        System.out.println("1- add new song, 2- list of songs in the player, 3 - play, 4 - add song after song=name, 5- exit");

        Scanner sc1 = new Scanner(System.in);
        while (!(choice.equals("5"))) {

            System.out.println();
            System.out.print("Input your choice = ");
            choice = sc1.nextLine();

            switch (choice) {
                case "1": {
                    mediaPlayer.add(songNew());
                    System.out.println();
                }

                case "2": {
                    int indexQueue = 0;
                    for (Media media : mediaPlayer) {
                        System.out.println("#" + indexQueue + " = " + media.toString());
                        indexQueue++;
                    }
                    System.out.println();
                }

                case "3": {
                    int indexQueue = 0;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please, enter type af play (1- one song, 2 - all time, 3 - all song one time:");
                    String select = sc.nextLine();

                    if (select.equals("1")) {
                        boolean isFoundSong = false;
                        System.out.println("Input name of song for play:");
                        String songName = sc.nextLine();
                        sc.close();
                        for (Media media : mediaPlayer) {
                            if (songName.equals(media.getSongName())) {
                                System.out.println("#" + indexQueue + " = " + media.toString() + "playing.....");
                                try {
                                    Thread.sleep(1000);//media.getSongLength() * 10
                                }catch (InterruptedException e){
                                    System.out.println("Exception");
                                }
  //                              TimeUnit.SECONDS.sleep(media.getSongLength());
                                isFoundSong = true;
                                break;
                            }
                        }
                        if(isFoundSong == false) System.out.println("This song absent in media player");
                    }

//                    if (select == "3") {
//                        for (Media media : mediaPlayer) {
//                            System.out.println("#" + indexQueue + " = " + media.toString() + "playing.....");
////                            TimeUnit.SECONDS.sleep(media.getSongLength());
//                        }
//                    }
                }

                case "4": {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Input name of song after which add a new one = ");
                    String songName = sc.nextLine();
                    boolean isFoundSong = false;
                    for (int i = 0; i < mediaPlayer.size(); i++) {
                        Media media = new Media("", "", 0);
                        media = mediaPlayer.get(i);
                        if (media.getSongName().equals(songName)) {
                            mediaPlayer.add(i + 1, songNew());
                            System.out.println("Song have added!!!");
                            isFoundSong = true;
                        }
                    }
                    if (isFoundSong == false) System.out.println("This song absent in media player");
                }
            }
        }
    }

    public static Media songNew() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Author name = ");
        String songAuthor = sc.nextLine();
        System.out.print("Input Song name = ");
        String songName = sc.nextLine();
        System.out.print("Input song length (s) = ");
        int songLength = sc.nextInt();
        return new Media(songAuthor, songName, songLength);
    }
}
