package faang.school.godbless.bjs2_26008;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                isPlaying = true;
                System.out.println("Start playing music");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is stopped");
            } else {
                System.out.println("Music is already stopped");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Play the next track");
            } else {
                isPlaying = true;
                System.out.println("Play the next track");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Play the previous track");
            } else {
                isPlaying = true;
                System.out.println("Play the previous track");
            }
        }
    }
}
