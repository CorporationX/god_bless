package faang.school.godbless.multithreadingS4.spotify;

public class Player {
    private final Object lock = new Object();

    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing.");
            } else {
                System.out.println("Playing music.");
                isPlaying = true;
            }
        }

    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip track.");
            isPlaying = false;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = true;
        }

    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Music is already paused.");
            } else {
                System.out.println("Pausing music.");
                isPlaying = false;
            }
        }

    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track.");
            isPlaying = false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = true;
        }
    }
}