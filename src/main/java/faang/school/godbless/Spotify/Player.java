package faang.school.godbless.Spotify;

public class Player {
    private final String lock;
    private Boolean isPlaying;

    public Player(String lock) {
        this.lock = lock;
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                isPlaying = true;
                System.out.println("Music is playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is stopped");
            } else {
                System.out.println("Music is already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous track");
        }
    }
}
