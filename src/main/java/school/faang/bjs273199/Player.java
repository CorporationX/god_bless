package school.faang.bjs273199;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.printf("The track is playing by %s %n", Thread.currentThread().getName());
            } else {
                System.out.printf("The track is already playing by %s %n", Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.printf("The track is paused by %s %n", Thread.currentThread().getName());
            } else {
                System.out.printf("The track is not playing by %s %n", Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.printf("The track is skipped by %s %n", Thread.currentThread().getName());
            sleep();
        }

    }

    public void previous() {
        synchronized (lock) {
            System.out.printf("Moved to previous track by %s %n", Thread.currentThread().getName());
            sleep();
        }

    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
