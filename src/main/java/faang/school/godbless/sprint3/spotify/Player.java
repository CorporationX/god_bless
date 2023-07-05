package faang.school.godbless.sprint3.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Playing");
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Skipping");
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Pausing");
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Previous");
    }
}
