package school.faang.BJS2_61707;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                isPlaying = true;
                System.out.println("Music is started playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is paused");
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public synchronized void skip() {
        System.out.println("Skip music is acted");
    }

    public synchronized void previous() {
        System.out.println("Previous music is acted");
    }
}