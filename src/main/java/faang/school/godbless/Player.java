package faang.school.godbless;

public class Player {
    private Object lock;
    private boolean isPlaying;

    public Player() {
        lock = new Object();
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing music.");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pausing music.");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to the next track.");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Playing the previous track.");
            }
        }
    }
}
