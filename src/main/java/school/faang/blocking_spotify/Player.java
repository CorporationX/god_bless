package school.faang.blocking_spotify;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music started to play");
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music paused");
            } else {
                System.out.println("Music has already been paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Moving to the next song");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Moving to the previous song");
        }
    }
}