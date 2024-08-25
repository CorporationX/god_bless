package faang.school.godbless.BJS2_24528;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music started playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music was stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music was skipped");
            if (isPlaying) {
                System.out.println("Next music started playing");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Return to previous music");
            if (isPlaying) {
                System.out.println("Previous music started playing");
            }
        }
    }
}
