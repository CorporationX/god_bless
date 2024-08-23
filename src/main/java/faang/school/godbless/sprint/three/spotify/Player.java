package faang.school.godbless.sprint.three.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (this.lock) {
            this.isPlaying = true;
            System.out.printf("%s playing song. play state %b %n", Thread.currentThread().getName(), this.isPlaying);
        }
    }

    public void pause() {
        synchronized (this.lock) {
            this.isPlaying = false;
            System.out.printf("%s paused song. play state %b%n", Thread.currentThread().getName(), this.isPlaying);
        }
    }

    public void skip() {
        synchronized (this.lock) {
            this.isPlaying = false;
            System.out.printf("%s skipped song. play state %b%n", Thread.currentThread().getName() ,this.isPlaying);
        }
    }

    public void previous() {
        synchronized (this.lock) {
            this.isPlaying = true;
            System.out.printf("%s play previous song. play state %b%n", Thread.currentThread().getName(), this.isPlaying);
        }
    }
}
