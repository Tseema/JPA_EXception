package com.relearn.practice;

import java.util.HashSet;
import java.util.Set;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        Set<Song> playlist = new HashSet<>();
        boolean isRepeatingPlaylist = false;
        Song currentsong = this;
        Song nexton = this.nextSong;

        while( currentsong != null && nexton != null ){
            playlist.add(currentsong);

            if(playlist.contains(nexton.nextSong)){
                isRepeatingPlaylist = true;
                return  isRepeatingPlaylist;
            }
            else{
                currentsong = nexton;
                nexton = nexton.nextSong;
            }
        }


       return  isRepeatingPlaylist;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("Eye of the tigerk sdjf");

        first.setNextSong(second);
        second.setNextSong(third);
        //third.setNextSong(first);


        System.out.println(first.isInRepeatingPlaylist());
    }
}
