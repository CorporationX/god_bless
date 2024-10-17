package Spotifi;

public class Player {
    private final Object lock = new Object();
    private boolean isPlayer;

    public void play() {
        synchronized (lock) {
            if (!isPlayer) {
                isPlayer = true;
                System.out.println("the music is playing");
            } else {
                System.out.println(" the music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlayer) {
                isPlayer = false;
                System.out.println("the Music is paused");
            } else {
                System.out.println("the music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(" returned to the previous track");
        }
    }
}

