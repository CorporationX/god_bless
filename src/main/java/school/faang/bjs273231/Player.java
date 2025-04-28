package school.faang.bjs273231;

public class Player {

    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("track is now playing");
            } else {
                System.out.println("track is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("track is paused");
            } else {
                System.out.println("track is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("track is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous track is playing");
        }
    }
}
