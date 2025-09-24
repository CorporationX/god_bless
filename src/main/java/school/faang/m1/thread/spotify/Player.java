package school.faang.m1.thread.spotify;

import lombok.Getter;

public class Player {

    private final Object lock = new Object();

    @Getter
    public boolean isPlaying;

    void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Player.play isPlaying = " + isPlaying());
        }
    }

    void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Player.pause isPlaying = " + isPlaying());
        }
    }

    void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Player.skip isPlaying = " + isPlaying());
        }
    }

    void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Player.previous isPlaying = " + isPlaying());
        }
    }
}
