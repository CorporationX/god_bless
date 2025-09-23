package school.faang.bjs88325;

public class Player {
    private final Object lock = new Object();
    private Boolean isPlaying;

    public Player() {
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Playing music... ");
            } else {
                System.out.println("Music paused... ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music paused... ");
            } else {
                System.out.println("Music is already paused... ");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music skipped... ");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Music previous played... ");
        }
    }
}
