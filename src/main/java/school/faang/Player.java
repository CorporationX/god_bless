package school.faang;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music start play");
            } else {
                System.out.println("the music is already play");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music on pause");
            } else {
                System.out.println("the music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track skiped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous played");
        }

    }
}

