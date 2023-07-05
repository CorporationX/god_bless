package faang.school.godbless.spotify_blocker;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing music");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pausing music");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping to next track");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Playing previous track");
            isPlaying = true;
        }
    }
}
