package faang.school.godbless.spring_4.blocking_spotify;

public class Player {
    private final Object lock = new Object();

    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
    }

    public synchronized void skip() {

    }

    public synchronized void previous() {

    }
}

