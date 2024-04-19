package faang.school.godbless.spotifyblock;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

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
        synchronized (lock) {
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
        }
    }
}
