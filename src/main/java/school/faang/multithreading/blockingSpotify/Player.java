package school.faang.multithreading.blockingSpotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Player is playing");
            } else {
                System.out.println("The player is already playing");
            }

        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Player is paused");
            } else {
                System.out.println("The player is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Song is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Song is previous");
        }
    }

}
