package faang.school.godbless.multithreading.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("> already playing!");
            } else {
                isPlaying = true;
                System.out.printf("> playing by %s%n", Thread.currentThread().getName());
            }

        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.printf("> nothing to pause by %s%n", Thread.currentThread().getName());
            } else {
                isPlaying = false;
                System.out.printf("> paused by %s%n", Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.printf("> nothing to skip by %s%n", Thread.currentThread().getName());
            } else {
                System.out.printf("> skipping by %s%n", Thread.currentThread().getName());
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.printf("> switching to previous track by %s%n", Thread.currentThread().getName());
        }
    }

}
