package faang.school.godbless.spotify_lock;

public class Player {
    private String lock = "lock";
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Playing...");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Pause.");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Skipping current song...");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing previous song...");
        }
    }
}
