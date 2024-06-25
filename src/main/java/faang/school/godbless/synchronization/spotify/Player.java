package faang.school.godbless.synchronization.spotify;

public class Player {

    private final Object lock = new Object();
    boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                System.out.println("Start playing music");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Music is already paused");
            } else {
                System.out.println("Pause music");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Start next track");
            } else {
                System.out.println("Music stopped. Turn on next track");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Start previous track");
            } else {
                System.out.println("Music stopped. Turn on previous track");
            }
        }
    }
}
