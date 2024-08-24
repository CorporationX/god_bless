package faang.school.godbless.BJS2_24266;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Already playing!");
            } else {
                isPlaying = true;
                System.out.printf("Playing by %s%n", Thread.currentThread().getName());
            }

        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.printf("Nothing to pause by %s%n", Thread.currentThread().getName());
            } else {
                isPlaying = false;
                System.out.printf("Paused song by %s%n", Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.printf("Nothing to skip by %s%n", Thread.currentThread().getName());
            } else {
                System.out.printf("Skipping music by %s%n", Thread.currentThread().getName());
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.printf("Switch to previous song by %s%n", Thread.currentThread().getName());
        }
    }
}
