package faang.school.godbless.Spotify;

public class Player {
    private final Object lock;

    public Player(Object lock) {
        this.lock = lock;
    }

    public static boolean isPlaying = false;

    public void play() throws InterruptedException {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Player starts playing!");
                isPlaying = true;
                lock.wait();
            } else {
                lock.wait();
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Player is pausing!");
                isPlaying = false;
                lock.notify();
            }
            lock.notify();
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Player is skipping!");
                lock.notify();
            }
            lock.notify();
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Player step to previous!");
            lock.notify();
        }
    }

}
