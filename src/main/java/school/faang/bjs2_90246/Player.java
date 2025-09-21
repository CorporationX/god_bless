package school.faang.bjs2_90246;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Play music");
            } else {
                System.out.println("Music is already on");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Pause");
            } else {
                System.out.println("The music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip track");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track");
        }
    }
}
