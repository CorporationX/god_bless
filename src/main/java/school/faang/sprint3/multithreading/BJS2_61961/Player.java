package school.faang.sprint3.multithreading.BJS2_61961;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("The player starts playing.");
            } else {
                System.out.println("The player already has been playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The player has been paused...");
            } else {
                System.out.println("The player is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The player has started playing next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("The player has started playing previous track");
        }
    }
}
