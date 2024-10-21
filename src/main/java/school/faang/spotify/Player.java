package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public synchronized void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Starting playing music...");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing...");
            }
        }
    }

    public synchronized void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is paused...");
                isPlaying = false;
            } else {
                System.out.println("Music is not playing...");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The track is skipped...");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track is selected...");
        }
    }
}
