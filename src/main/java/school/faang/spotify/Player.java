package school.faang.spotify;

public class Player {

    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            System.out.println("Playing music");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Stopped music");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping music");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Playing last composition");
        }
    }


}
