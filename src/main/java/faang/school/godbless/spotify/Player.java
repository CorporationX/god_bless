package faang.school.godbless.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Starting playing song!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Song is started!\n" +
                    "-------------");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Pausing the song...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Song is paused!\n" +
                    "-------------");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping the song...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Next song ->\n" +
                    "-------------");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Comeback to previous song...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("<- Previous song\n" +
                    "-------------");
            isPlaying = true;
        }
    }
}
