package bjs2_37377;

public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        this.lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            System.out.println("isPlaying before: " + isPlaying);
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " start play");
            System.out.println("isPlaying after: " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("isPlaying before: " + isPlaying);
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " get pause");
            System.out.println("isPlaying after: " + isPlaying);

        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " skip song");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " return on previous");
        }
    }
}
