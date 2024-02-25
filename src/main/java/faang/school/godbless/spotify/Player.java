package faang.school.godbless.spotify;

public class Player {

    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            System.out.println("Playing...");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Paused...");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped...");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous...");
            isPlaying = true;
        }
    }
}
