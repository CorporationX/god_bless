package spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
        }
    }
}
