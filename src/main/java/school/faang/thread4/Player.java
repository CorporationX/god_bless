package school.faang.thread4;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Player {
    private final Lock lock = new ReentrantLock();
    private String isPlaying;

    public String play() {
        synchronized (lock) {
            isPlaying = "Music is playing";
            System.out.println(isPlaying);
            return isPlaying;
        }
    }

    public String pause() {
        synchronized (lock) {
            isPlaying = "Music paused";
            System.out.println(isPlaying);
            return isPlaying;
        }
    }

    public String skip() {
        synchronized (lock) {
            isPlaying = "Music skipped";
            System.out.println(isPlaying);
            return isPlaying;
        }
    }

    public String previous() {
        synchronized (lock) {
            isPlaying = "Music turned to previous";
            System.out.println(isPlaying);
            return isPlaying;
        }
    }
}
