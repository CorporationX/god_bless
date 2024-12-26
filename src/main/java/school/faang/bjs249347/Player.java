package school.faang.bjs249347;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public Player() {
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " start listen music.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " put on pause.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " skip track.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " come back previous track.");
        }
    }
}
