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

    public void skip() {

    }

    public void previous() {

    }
}

