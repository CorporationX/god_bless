package sprint4.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println("Let's dance!!");
            isPlaying = true;
            System.out.println("Music was on: " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Stop dance!!");
            isPlaying = false;
            System.out.println("Music was off: " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip that slag!!");
            isPlaying = true;
            System.out.println("Current music was skip: " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Let's do it again!!");
            isPlaying = true;
            System.out.println("Previous music was on: " + isPlaying);
        }
    }
}
