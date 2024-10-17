package school.faang.spotifyblocking;

import lombok.Data;

@Data
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("The track is playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The track is paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Return to the previous track");
        }
    }
}
