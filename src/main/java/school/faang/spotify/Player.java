package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(String.format("%s - Playing track ", Thread.currentThread().getName()));
            } else {
                System.out.println(String.format("%s - Already playing track ", Thread.currentThread().getName()));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(String.format("%s - Paused track ", Thread.currentThread().getName()));
            } else {
                System.out.println("Already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(String.format("%s - Skipped to track ", Thread.currentThread().getName()));
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(String.format("%s Went back to track ", Thread.currentThread().getName()));

        }
    }
}
