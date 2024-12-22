package school.faang.task_49229;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Start playing by thread: " + Thread.currentThread().getName());
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("On pause by thread: " + Thread.currentThread().getName());
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skip song by thread: " + Thread.currentThread().getName());
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Previous song by thread: " + Thread.currentThread().getName());
            }
        }
    }
}
