package school.faang.multithreading.synchronize.bjs2_90310;

public class Player {

    private static boolean isPlaying;
    private final Object lock;

    public Player(Object lock) {
        this.lock = lock;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Start playing music");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pause music");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skip track");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Back to previous track");
            }
        }
    }
}