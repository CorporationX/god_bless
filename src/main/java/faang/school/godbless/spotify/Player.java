package faang.school.godbless.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.printf( "Player is playing: %s%n", isPlaying );
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.printf( "Player is  playing: %s%n", isPlaying );
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println( "Player is skipping to next song" );
            lock.notify();
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println( "Player is playing previous song" );
            lock.notify();
        }
    }
}
