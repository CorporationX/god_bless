package school.faang.blocking_spotify_BJS2_37147;

public class Player {
    private final String lock = "lock";
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Player is already playing");
            } else {
                isPlaying = true;
                System.out.println("Music started playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Player is not playing");
            } else {
                isPlaying = false;
                System.out.println("Music paused");
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
            System.out.println("Returned to previous track");
        }
    }
}
