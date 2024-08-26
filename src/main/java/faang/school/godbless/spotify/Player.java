package faang.school.godbless.spotify;

import lombok.Getter;

import java.util.Random;

@Getter
public class Player {
    private boolean isPlaying = false;
    private Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("The track is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("The track is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            getTrack();
            System.out.println("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            getTrack();
            System.out.println("Moving to the previous track");
        }
    }

    public void getTrack() {
        try {
            Thread.sleep(new Random().nextLong(1000L));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
