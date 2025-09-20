package bjs290202;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music starts playing!");
            } else {
                System.out.println("Music already is on!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music stops playing!");
            } else {
                System.out.println("Music already is off!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("1 song is skipped!");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous song stars playing!");
        }
    }
}
