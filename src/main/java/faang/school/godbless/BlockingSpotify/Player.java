package faang.school.godbless.BlockingSpotify;

import java.time.LocalTime;

public class Player {
    private Object lock = new Object();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "play";
            System.out.println(isPlaying + " " + LocalTime.now());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "pause";
            System.out.println(isPlaying + " " + LocalTime.now());
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "skip";
            System.out.println(isPlaying + " " + LocalTime.now());
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "previous";
            System.out.println(isPlaying + " " + LocalTime.now());
        }
    }
}
