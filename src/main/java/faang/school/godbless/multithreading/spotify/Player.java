package faang.school.godbless.multithreading.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public Player() {
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music plays " + Thread.currentThread().getName());
            detain();
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music paused " + Thread.currentThread().getName());
            detain();
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music skipped " + Thread.currentThread().getName());
            detain();
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous " + Thread.currentThread().getName());
            detain();
        }
    }

    /*Этот метод просто для наглядности работы synchronized*/
    private void detain() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
