package derschrank.sprint03.task05.bjstwo_49183;

public class Player implements PlayerInterface {

    private final Object lock;
    private boolean isPlaying;

    public Player() {
        lock = new Object();
    }

    @Override
    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is playing now");
            } else {
                System.out.println("Music is playing ALREADY");
            }

        }
    }

    @Override
    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is paused now");
            } else {
                System.out.println("Music is paused ALREADY");
            }
        }
    }

    @Override
    public void skip() {
        synchronized (lock) {
            System.out.println("Next track");
        }
    }

    @Override
    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track");
        }
    }
}
