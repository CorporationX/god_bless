package faang.school.godbless.spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous");
        }
    }
}
