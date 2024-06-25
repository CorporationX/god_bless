package faang.school.godbless.blockSpotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if(!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " is playing the music.");
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to play, but music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " has paused the music.");
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to pause, but music is already paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " has skipped to the next track.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " has returned to the previous track.");
        }
    }
}
