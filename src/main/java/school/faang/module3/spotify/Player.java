package school.faang.module3.spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("already playing");
                return;
            }
            isPlaying = true;
            System.out.println("playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("already paused");
                return;
            }
            isPlaying = false;
            System.out.println("paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("music skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("select previous music");
        }
    }
}
