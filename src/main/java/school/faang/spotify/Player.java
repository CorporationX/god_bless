package school.faang.spotify;

public class Player {
    private boolean isPlaying = false;
    private final Object lock = new Object();

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
            System.out.println("Song is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous song");
        }
    }
}
