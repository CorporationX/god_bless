package school.faang;

public class Player {
    private final Object lock = new Object();
    private static boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                isPlaying = true;
                System.out.println("Music is playing! Enjoy!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Music is already paused");
            } else {
                isPlaying = false;
                System.out.println("Music is paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Get back to the previous track");
        }
    }
}
