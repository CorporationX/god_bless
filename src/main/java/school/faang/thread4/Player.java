package school.faang.thread4;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Player {
    private final Lock lock = new ReentrantLock();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "Music is playing";
            System.out.println(isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "Music paused";
            System.out.println(isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "Music skipped";
            System.out.println(isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "Music turned to previous";
            System.out.println(isPlaying);
        }
    }
}
