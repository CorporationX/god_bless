package school.faang.spoty;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int currentTrack = 0;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing track " + currentTrack);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Paused track " + currentTrack);
        }
    }

    public void skip() {
        synchronized (lock) {
            currentTrack++;
            System.out.println("Skipped to track " + currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentTrack > 0) {
                currentTrack--;
            }
            System.out.println("Went back to track " + currentTrack);
        }
    }

    public boolean isPlaying() {
        synchronized (lock) {
            return isPlaying;
        }
    }

    public int getCurrentTrack() {
        synchronized (lock) {
            return currentTrack;
        }
    }
}
