package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task3;

public class Player {

    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("player is playing " + isPlaying);
            lock.notifyAll();
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("player is playing " + isPlaying);
            lock.notifyAll();
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("player is playing " + isPlaying);
            lock.notifyAll();
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("player is playing " + isPlaying);
            lock.notifyAll();
        }
    }
}
