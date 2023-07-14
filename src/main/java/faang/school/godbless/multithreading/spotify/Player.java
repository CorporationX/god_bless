package faang.school.godbless.multithreading.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Getter;

@Getter
public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing music");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause the music");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Skip a song");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Select the previous song");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
