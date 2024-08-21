package BJS2_24315_BlockingSpotify;

import lombok.Getter;

@Getter
public class Player {
    private final static Object lock = new Object();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "Yes! Playing music!";
            System.out.println(Thread.currentThread().getName() + " Is playing? " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "paused player!";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "Skipped to next song!";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "Rewind to previous song!";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }
    }
}
