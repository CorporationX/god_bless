package faang.school.godbless.blocking.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " \"play\" music");
        }
    }
    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " \"pause\" music");
        }
    }
    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " skipped to the next track.");
        }
    }
    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " went back to the previous track.");
        }
    }
}
