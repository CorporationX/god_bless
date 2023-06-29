package faang.school.godbless.blocking_spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music started playing. Is music playing - " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music stopped. Is music playing - " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Started next track. Is music playing - " + isPlaying);
        }
    }

    public void previous () {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Started previously track. Is music playing - " + isPlaying);
        }
    }

    public static void main(String[] args) {
        Player player = new Player();
        Thread playingThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        playingThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
