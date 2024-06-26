package faang.school.godbless.multithreading.synchronization.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;


    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("play");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous");
        }
    }
}
