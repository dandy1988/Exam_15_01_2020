package com.dandy1988;

public class Song {
    private String name;
    private String author;
    private long songLength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getSongLength() {
        return songLength;
    }

    public void setSongLength(long songLength) {
        this.songLength = songLength;
    }

    @Override
    public String toString() {
        return  name + " - " + author + " - " + songLength + "(s)";
    }

    public Song(String author, String name, long songLength) {
        this.name = name;
        this.author = author;
        this.songLength = songLength;
    }
}
