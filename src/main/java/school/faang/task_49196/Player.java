package school.faang.task_49196;

public class Player {
    private final Object lock = new Object();
    private volatile boolean isPlaying;

    public Player(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("The track started to play");
            } else {
                System.out.println("The track is playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The track is on pause");
            } else {
                System.out.println("The track is stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The track is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Back to the previous track");
        }
    }
}