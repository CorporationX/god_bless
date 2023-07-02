package faang.school.godbless.Sprint_4.Multithreading_Synchronization.SpotifyBlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private boolean isPlaying;
    private final Lock lock = new ReentrantLock();

    public void play() {
        synchronized (lock) {
            System.out.println("You are going to play...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("SleepError");
            }

            isPlaying = true;
            System.out.println("Playing the song");
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Pausing the song...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("SleepError");
            }

            isPlaying = false;
            System.out.println("The song was paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Skipping the song...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("SleepError");
            }

            isPlaying = true;
            System.out.println("The song was skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Going to the previous song...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("SleepError");
            }

            isPlaying = true;
            System.out.println("Now is playing previous song...again");
        }
    }
}
