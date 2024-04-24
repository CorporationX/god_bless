package faang.school.godbless.Syncrhonization.Spotify;

public class Player {
    private static final Object LOCK = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (LOCK) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Play music");
            } else {
                System.out.println("Music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (LOCK) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Pause music.");
            } else {
                System.out.println("Music is already paused.");
            }
        }
    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("Skip song");
        }
    }

    public void previous() {
        synchronized (LOCK) {
            System.out.println("Back to previous song");
        }
    }
}
