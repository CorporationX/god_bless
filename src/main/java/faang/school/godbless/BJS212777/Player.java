package faang.school.godbless.BJS212777;

public class Player {
    Object lock = new Object();
    boolean isPlaying;
    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Melody has already played");
            } else {
                isPlaying = true;
                lock.notify();
                System.out.println("Start playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Melody has already paused");
            } else {
                isPlaying = false;
                lock.notify();
                System.out.println("Pause playing");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            while (!isPlaying) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted: " + e.getMessage());
                }
            }
            System.out.println("Skip playing melody");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            lock.notify();
            System.out.println("Playing previous melody");
        }
    }

    public void finishWaiting() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                lock.notify();
            }
        }
    }
}
