package school.faang.bjs249150;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music track is playing " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music track is playing " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous music track");
        }
    }
}