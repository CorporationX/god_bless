package school.faang.synchSpotify;

public class Player {
    final Object lock = new Object();
    boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " - start playing...");
            } else {
                System.out.println(Thread.currentThread().getName() + " - playing now...");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " - stop playing (pause)...");
            } else {
                System.out.println(Thread.currentThread().getName() + " - pause now...");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " - skip...");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " - previous...");
        }
    }
}
