package faang.school.godbless.spotify;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("track is playing");
        }
    }

    void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("track was paused");
        }
    }

    void skip() {
        synchronized (lock) {
            System.out.println("skip this track");
        }
    }

    void previous() {
        synchronized (lock) {
            System.out.println("previous track");
        }
    }
}
