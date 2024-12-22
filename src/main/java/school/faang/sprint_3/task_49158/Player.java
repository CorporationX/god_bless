package school.faang.sprint_3.task_49158;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Player is playing by " + Thread.currentThread().getName());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Player is paused by " + Thread.currentThread().getName());
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Song skipped by " + Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous song by " + Thread.currentThread().getName());
        }
    }
}
