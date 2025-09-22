package school.faang.bjs2_90320;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Play " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            this.isPlaying = false;
            System.out.println("Pause " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Next song " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Previous song " + isPlaying);
        }
    }
}