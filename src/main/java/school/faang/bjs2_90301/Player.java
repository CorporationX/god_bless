package school.faang.bjs2_90301;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Track is now playing.");
            } else {
                System.out.println("Track is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Track is now paused.");
            } else {
                System.out.println("Track is already paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped to next track.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Skipped to previous track.");
        }
    }
}
