package faang.school.godbless.blocking.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if(!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " \"play\" music");
            }
            else {
                System.err.println("Music already playing!");
            }
        }
    }
    public void pause() {
        synchronized (lock) {
            if(isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " \"pause\" music");
            }
            else {
                System.err.println("Music already paused!");
            }
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
