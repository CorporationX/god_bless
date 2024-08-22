package faang.school.godbless.spotify;

public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        this.lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is playing");
            }
        }
    }
    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is paused");
            }
        }
    }
    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Current song is skipped");
            }
            isPlaying = true;
            System.out.println("Next song is playing");
        }
    }
    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Current song stopped playing");
            }
            isPlaying = true;
            System.out.println("Previous song is playing");
        }
    }
}
