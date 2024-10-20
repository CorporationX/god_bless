package blocking_spotify;

public class Player {
    private static final Object lock = new Object();
    private boolean isPlaying = false;

    /**
     * Notifies any waiting threads that the player is playing and
     * notifies them to proceed.
     */
    public void play() {
        synchronized (lock) {
            System.out.println("Playing...");
            isPlaying = true;
            lock.notify();
        }
    }

    /**
     * Notifies any waiting threads that the player is paused and
     * notifies them to proceed.
     */
    public void pause() {
        synchronized (lock) {
            System.out.println("Pausing...");
            isPlaying = false;
            lock.notify();
        }
    }

    /**
     * Notifies any waiting threads that the player has skipped to the
     * next song and notifies them to proceed.
     */
    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping...");
            isPlaying = false;
            lock.notify();
        }
    }

    /**
     * Notifies any waiting threads that the player has skipped to the
     * previous song and notifies them to proceed.
     */
    public void previous() {
        synchronized (lock) {
            System.out.println("Previous...");
            isPlaying = false;
            lock.notify();
        }
    }
}
