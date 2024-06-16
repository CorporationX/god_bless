package faang.school.godbless.spotify;

public class Player {
    private final static Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("play");
            isPlaying = false;
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("pause");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("skip");
            isPlaying = false;
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("previous");
            isPlaying = false;
        }
    }
}
