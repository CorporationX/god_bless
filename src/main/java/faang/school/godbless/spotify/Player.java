package faang.school.godbless.spotify;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized(lock) {
            isPlaying = true;
            System.out.println("Playing");
        }
    }
    public void pause() {
        synchronized(lock) {
            isPlaying = false;
            System.out.println("Paused");
        }
    }

    public void skip() {
        synchronized(lock) {
            System.out.println("Skipping");
            isPlaying = true;
            lock.notify();
        }
    }

    public void previous() {
        synchronized(lock) {
            System.out.println("Previous");
            isPlaying = true;
            lock.notify();
        }
    }

}
