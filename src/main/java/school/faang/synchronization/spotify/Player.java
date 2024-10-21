package school.faang.synchronization.spotify;

public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player(Object lock) {
        this.lock = lock;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is playing");
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying){
                isPlaying = false;
                System.out.println("Music is paused");
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Current music is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Returned to the previous music");
        }
    }

}
