package faang.school.godbless.Multitrading2.Spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Play music " + isPlaying);
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Pause music " + isPlaying);
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Next track " + isPlaying);
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Previous track " + isPlaying);
    }
}
