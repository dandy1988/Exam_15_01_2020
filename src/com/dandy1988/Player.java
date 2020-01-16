package com.dandy1988;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Interrupter interrupter = new Interrupter();
    String nameInsertPosition;
    int deletePosition;
    ArrayList<Song> mediaPlayer = new ArrayList<Song>() {{
        add(new Song("M. Jackson", "Billie Jean", 2));
        add(new Song("M. Jackson", "Earth Song", 3));
        add(new Song("M. Jackson", "Smooth Criminal", 10));
        add(new Song("Metallica", "Load", 30));
        add(new Song("Metallica", "The Unforgiven", 40));
    }};

    public void findSongAndAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name of song after which add a new one = ");
        String songName = sc.nextLine();
        boolean isFoundSong = false;
        for (int i = 0; i < mediaPlayer.size(); i++) {
            Song song1 = new Song("", "", 0);
            song1 = mediaPlayer.get(i);
            if (song1.getName().equals(songName)) {
                songNew(i);
                System.out.println("Song have added!!!");
                isFoundSong = true;
                break;
            }
        }
        if (isFoundSong == false) System.out.println("This song absent in media player");
    }

    public void songNew(int index) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Author name = ");
        String songAuthor = sc.nextLine();
        System.out.print("Input Song name = ");
        String songName = sc.nextLine();
        System.out.print("Input song length (s) = ");
        int songLength = sc.nextInt();
        mediaPlayer.add(index+1, new Song(songAuthor, songName, songLength));
    }

    public void songNew() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Author name = ");
        String songAuthor = sc.nextLine();
        System.out.print("Input Song name = ");
        String songName = sc.nextLine();
        System.out.print("Input song length (s) = ");
        int songLength = sc.nextInt();
        mediaPlayer.add(new Song(songAuthor, songName, songLength));
    }

    public void deleteSong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name of delete song = ");
        String songName = sc.nextLine();
        boolean isFoundSong = false;
        for (int i = 0; i < mediaPlayer.size(); i++) {
            Song song1 = new Song("", "", 0);
            song1 = mediaPlayer.get(i);
            if (song1.getName().equals(songName)) {
                mediaPlayer.remove(i);
                System.out.println("Song have deleted!!!");
                isFoundSong = true;
                break;
            }
        }
        if (isFoundSong == false) System.out.println("This song absent in media player");
    }

    public void outputListOfSong(){
        int indexQueue = 0;
        for (Song song : mediaPlayer) {
            System.out.println("#" + indexQueue + " = " + song.toString());
            indexQueue++;
        }
        System.out.println();
    }

    public void playSong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of song for play = ");
        int songIndex = 0;
        try {
            songIndex = sc.nextInt();
        } catch (Exception e) {
            System.out.println("wrong number of song");
        }
        if (songIndex <= mediaPlayer.size()) {
            System.out.println(mediaPlayer.get(songIndex).toString() + "playing...");
            ThreadDelay threadPlay = new ThreadDelay(interrupter, mediaPlayer.get(songIndex).getSongLength());

            interrupter.start();
            threadPlay.start();

            while (interrupter.isAlive()){
                if (threadPlay.isAlive()==false){
                    break;
                }
            }
            threadPlay.interrupt();
            interrupter.interrupt();
            MenuPlayer.work();
        }else{
            System.out.println("wrong number of song");
        }
    }
}



