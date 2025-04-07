package school.faang.spotify_blocking;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public Player() {
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void play() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("The song is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            this.isPlaying = false;
            System.out.println("Music paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track's skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Returned to the previous track");
        }
    }
}
