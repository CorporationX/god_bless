package Sportify_BJS2_37318;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Music is playing");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Playing of music paused");
                isPlaying = false;
            } else {
                System.out.println("Music is already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track is playing");
        }
    }
}