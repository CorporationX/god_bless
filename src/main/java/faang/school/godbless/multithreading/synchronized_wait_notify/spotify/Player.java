package faang.school.godbless.multithreading.synchronized_wait_notify.spotify;

public class Player {

    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        System.out.println("play...");
        synchronized (lock) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = true;
            System.out.println("song is playing");
        }

    }

    public void pause() {
        System.out.println("pause...");
        synchronized (lock) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = false;
            System.out.println("song is paused");
        }
    }

    public void skip() {
        System.out.println("skip...");
        synchronized (lock) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = false;
            System.out.println("skip to next");
        }
    }

    public void previous() {
        System.out.println("previous...");
        synchronized (lock) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = false;
            System.out.println("previous song");
        }
    }
}
