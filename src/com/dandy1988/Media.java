package com.dandy1988;

public class Media {
    private String songName;
    private String songAuthor;
    private long songLength;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongAuthor() {
        return songAuthor;
    }

    public void setSongAuthor(String songAuthor) {
        this.songAuthor = songAuthor;
    }

    public long getSongLength() {
        return songLength;
    }

    public void setSongLength(long songLength) {
        this.songLength = songLength;
    }

    @Override
    public String toString() {
        return  songName + " - " + songAuthor + " - " + songLength + "(s)";
    }

    public Media( String songAuthor, String songName, long songLength) {
        this.songName = songName;
        this.songAuthor = songAuthor;
        this.songLength = songLength;
    }
}
