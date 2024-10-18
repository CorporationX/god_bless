package dima.evseenko.spotify;

public class Player {
    private final Object lock = new Object();

    private PlayerState state = PlayerState.STOPPED;

    public void play() {
        synchronized (lock) {
            state = PlayerState.PLAYING;
            System.out.println("Playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            state = PlayerState.PAUSED;
            System.out.println("Paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            state = PlayerState.PLAYING;
            System.out.println("Skipping");
        }
    }

    public void previous() {
        synchronized (lock) {
            state = PlayerState.PLAYING;
            System.out.println("Previous");
        }
    }

    public boolean isPlaying() {
        return state == PlayerState.PLAYING;
    }
}