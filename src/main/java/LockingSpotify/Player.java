package LockingSpotify;

public class Player {

    private Object lock = new Object();

    private boolean isPlaying = false;

    public synchronized void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
        }
    }

    public synchronized void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
        }
    }

    public synchronized void skip() {
        synchronized (lock) {
            isPlaying = true;
        }
    }

    public synchronized void previous() {
        synchronized (lock) {
            isPlaying = true;
        }
    }
}
