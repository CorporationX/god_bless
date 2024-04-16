package spotify;

public class Player {
    private final Object lock = new Object();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            this.isPlaying = "play";
        }
    }

    public void pause() {
        synchronized (lock) {
            this.isPlaying = "pause";
        }
    }

    public void skip() {
        synchronized (lock) {
            this.isPlaying = "skip";
        }
    }

    public void previous() {
        synchronized (lock) {
            this.isPlaying = "previous";
        }
    }
}
