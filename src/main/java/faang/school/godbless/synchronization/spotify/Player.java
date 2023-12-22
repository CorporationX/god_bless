package faang.school.godbless.synchronization.spotify;

import lombok.Getter;

public class Player {

    private final Object lock;
    @Getter
    private boolean isPlaying;

    public Player() {
        lock = new Object();
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play method");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = !isPlaying;
            System.out.println("Pause method");
        }
    }

    public void previous() {
        System.out.println("Previous method");
    }

    public void skip() {
        System.out.println("Skip method");
    }

}
