package school.faang.spotify.lock;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized(lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " uses \"play\"");
        }
    }

    public void pause() {
        synchronized(lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " uses \"pause\"");
        }
    }

    public void skip() {
        synchronized(lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " uses \"skip\"");
            play();
        }
    }

    public void previous() {
        synchronized(lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " uses \"previous\"");
            play();
        }
    }
}
