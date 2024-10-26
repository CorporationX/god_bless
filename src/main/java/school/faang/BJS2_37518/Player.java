package school.faang.BJS2_37518;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " Start playing ");
            } else {
                System.out.println(Thread.currentThread().getName() + "Already playing ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " pause on ");
            } else {
                System.out.println(Thread.currentThread().getName() + " already paused ");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " skip a track ");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " return to privious track ");
        }
    }
}
