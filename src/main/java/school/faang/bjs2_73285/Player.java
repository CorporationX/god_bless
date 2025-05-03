package school.faang.bjs2_73285;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int trackNumber = 1;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.printf("Track %d is playing%n", trackNumber);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.printf("Track %d is paused%n", trackNumber);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.printf("Next track number - %d%n", ++trackNumber);
        }
    }

    public void previous() {
        synchronized (lock) {
            if (trackNumber > 1) {
                System.out.printf("Previous track number - %d%n", --trackNumber);
            }
        }
    }
}
