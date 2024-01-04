package faang.school.godbless.BJS2_1231;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Play music");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pause music");
                isPlaying = false;
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skip to the next track");
            } else {
                System.out.println("Cannot skip, music is paused");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Go back to the previous track");
            } else {
                System.out.println("Cannot go back, music is paused");
            }
        }
    }
}