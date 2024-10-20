package school.faang.BJS2_37276_BlockingSpotify;

public class Player {
    private Object lock;
    private boolean isPlaying;

    public Player() {
        lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("The music player is already playing.");
            } else {
                isPlaying = true;
                System.out.println("The music player has been taken off pause.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("The music player has been already paused.");
            } else {
                isPlaying = false;
                System.out.println("The music player has been paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("The track has been skipped. Now playing the next track.");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Now playing the previous track.");
        }
    }
}
