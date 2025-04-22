package spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing ");
                isPlaying = true;
            } else {
                System.out.println("Song is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Paused");
                isPlaying = false;
            } else {
                System.out.println("Song is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous");
        }
    }

}
