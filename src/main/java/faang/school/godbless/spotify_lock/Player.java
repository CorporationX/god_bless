package faang.school.godbless.spotify_lock;

public class Player {
    private String lock = "lock";
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing...");
                isPlaying = true;
            } else {
                System.out.println("Already playing...");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pause.");
                isPlaying = false;
            } else {
                System.out.println("Already paused");
            }
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
