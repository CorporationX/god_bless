package school.faang.multithreading.blockingSpotify;

public class Player {
    private final Object LOCK = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (LOCK) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Player is playing");
            } else {
                System.out.println("The player is already playing");
            }

        }
    }

    public void pause() {
        synchronized (LOCK) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Player is paused");
            } else {
                System.out.println("The player is already paused");
            }
        }
    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("Song is skipped");
        }
    }

    public void previous() {
        synchronized (LOCK) {
            System.out.println("Song is previous");
        }
    }

}
