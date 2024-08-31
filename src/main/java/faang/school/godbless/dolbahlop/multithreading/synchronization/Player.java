package faang.school.godbless.dolbahlop.multithreading.synchronization;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            System.out.println("Music is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Music has beeen paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music has been stopped");
            if (isPlaying) {
                System.out.println("Next music is playing");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Return to the previous music");
            if (isPlaying) {
                System.out.println("Previous music is playing");
            }
        }
    }
}
