package faang.school.godbless.Sprint4.Spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public Player() {
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing music");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pausing music");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to next song");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Switching to previous song");
            }
        }
    }
}
