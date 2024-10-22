package school.faang_sprint_3.blocking_spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Song is playing");
            } else {
                System.out.println("Song is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Song is paused");
            } else {
                System.out.println("Song is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip the song");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Move to the previous song");
            play();
        }
    }
}
