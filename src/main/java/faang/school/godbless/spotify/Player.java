package faang.school.godbless.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true; // if
            System.out.println("Music is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music is skipped");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Music is switched to previous");
            isPlaying = true;
        }
    }
}
