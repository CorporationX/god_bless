package spotify.blocking;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music starts playing!");
            } else {
                System.out.println("Music already playing!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is paused!");
            } else {
                System.out.println("Music already paused!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music has been skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Music has been switched to the previous one");
        }
    }
}
