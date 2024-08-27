package faang.school.godbless.Spotify;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println(Thread.currentThread().getName() + ": Play");
                isPlaying = true;
            } else {
                System.out.println(Thread.currentThread().getName() + ": Already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + ": Pause");
                isPlaying = false;
            } else {
                System.out.println(Thread.currentThread().getName() + ": Already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Skipping to the next track");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Going to the previous track");
            isPlaying = true;
        }
    }
}