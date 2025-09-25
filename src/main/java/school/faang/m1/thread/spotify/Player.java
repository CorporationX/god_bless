package school.faang.m1.thread.spotify;

import lombok.Getter;

public class Player {

    private final Object lock = new Object();

    @Getter
    public boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music playing.");
            } else {
                System.out.println("Music already playing.");
            }
        }
        System.out.println("Player.play isPlaying = " + isPlaying());
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music stopped.");
            } else {
                System.out.println("Music already stopped.");
            }
            System.out.println("Player.pause isPlaying = " + isPlaying());
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music not playing. Skip to next and play.");
            } else {
                System.out.println("Music is playing current. Skip to next and play.");
            }
            System.out.println("Player.skip isPlaying = " + isPlaying());
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music not playing. Play previous.");
            } else {
                System.out.println("Music is playing current. Move to previous.");
            }
            System.out.println("Player.previous isPlaying = " + isPlaying());
        }
    }
}
