package MultithreadingSpotify;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (this) {
            if (isPlaying == false) {
                isPlaying = true;
                System.out.println("Started playing Music!!!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying == true) {
                isPlaying = false;
                System.out.println("Stopped playing Music!!!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped and Playing next Music!!!");
        }
    }

    public synchronized void previous() {
        synchronized (lock) {
            System.out.println("Previous and Playing previous Music!!!");
        }
    }
}
