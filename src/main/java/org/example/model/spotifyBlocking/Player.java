package org.example.model.spotifyBlocking;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> musics = new ArrayList<>();
    private int currentMusicIndex = 0;
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public Player(List<String> musics) {
        this.musics = musics;
    }

    public void play() {
        synchronized (lock) {
            System.out.println(musics.get(currentMusicIndex) + " is playing!");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println(musics.get(currentMusicIndex) + " on pause!");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("current music " + musics.get(currentMusicIndex) + " skipped to next!");
            currentMusicIndex = (currentMusicIndex + 1) % musics.size();
            play();
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("current music " + musics.get(currentMusicIndex) + " skipped to previous!");
            if(currentMusicIndex == 0) {
                currentMusicIndex = musics.size() - 1;
            } else {
                currentMusicIndex = currentMusicIndex - 1;
            }
            play();
        }
    }
}
