package faang.school.godbless.sprint3.blockSpotify;

public class Player {

    private Boolean isPlaying;
    private final Object lock = new Object();

    public Player() {
        this.isPlaying = false;
    }

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
