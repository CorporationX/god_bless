package school.faang.sprint3.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;


    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music already playing");
            } else {
                isPlaying = true;
                System.out.println("Play");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Music already paused");
            } else {
                isPlaying = false;
                System.out.println("Pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Pressed skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Pressed previous");
        }
    }
}
