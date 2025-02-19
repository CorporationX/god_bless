package school.faang.bjs2_61728;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Already playing");
                return;
            }
            isPlaying = true;
            System.out.println("Playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Already playing");
                return;
            }
            isPlaying = false;
            System.out.println("Paused");
        }
    }

    public void skip() throws InterruptedException {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Skipping to the next track...");
        }
        Thread.sleep(500);
        synchronized (lock) {
            isPlaying = true;
            System.out.println("The next track is playing");
        }
    }

    public void previous() throws InterruptedException {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Let's move on to the previous track...");
        }
        Thread.sleep(500);
        synchronized (lock) {
            isPlaying = true;
            System.out.println("The previous track is playing");
        }
    }
}
