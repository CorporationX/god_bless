package faang.school.godbless.r_edzie.synchronization.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println(Thread.currentThread().getName() + " PLAY");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + " PAUSE");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + " SKIP");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + " PREVIOUS");
            }
        }
    }
}
