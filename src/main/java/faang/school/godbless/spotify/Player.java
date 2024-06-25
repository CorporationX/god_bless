package faang.school.godbless.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                isPlaying = true;
                System.out.println("Playing music");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music paused");
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to the next song");
            } else {
                System.out.println("Cannot skip the next song, it is paused");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Going to the previous song");
            } else {
                System.out.println("Cannot go the previous song, it is paused");
            }
        }
    }
}
