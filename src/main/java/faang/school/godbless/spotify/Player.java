package faang.school.godbless.spotify;

public class Player {
    private final Object lock;
    private Boolean isPlaying;

    public Player() {
        this.lock = new Object();
    }

    void play() {
        synchronized (lock) {
            System.out.println("Some track is playing...");
            isPlaying = true;
        }
    }

    void pause() {
        synchronized (lock) {
            if (isPlaying = true) {
                System.out.println("Track was paused");
                isPlaying = false;
            }
        }
    }

    void skip() {
        synchronized (lock) {
            if (isPlaying = true) {
                System.out.println("Track was skipped and next track is playing");
            }
        }
    }

    void previous() {
        synchronized (lock) {
            System.out.println("Previous track is playing");
            isPlaying = true;
        }
    }
}
