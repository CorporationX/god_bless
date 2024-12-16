package school.faang.task_49156;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("isPlaying: " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("isPlaying: " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Player previous");
        }
    }
}
