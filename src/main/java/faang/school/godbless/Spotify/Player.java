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
                System.out.println(lock + " is already playing");
            }
            isPlaying = true;
            System.out.println(lock + " is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(lock + " is stopped");
            }
            System.out.println(lock + " is stopped");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Next " + lock);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous " + lock);
        }
    }
}
