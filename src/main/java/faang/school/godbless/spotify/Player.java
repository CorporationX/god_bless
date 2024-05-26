package faang.school.godbless.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println("song is playing");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("pause");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("skip");
            isPlaying = false;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous");
            isPlaying = false;
        }
    }
}
