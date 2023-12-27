package stream.spotify;

public class Player {

    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            lock.notify();
            System.out.println("Music playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music stopped");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The song was skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The previous song is on");
        }
    }
}
