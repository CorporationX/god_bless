package faang.school.godbless.synchronize.blockSpotify;

import lombok.Data;

@Data
public class Player {
    private boolean isPlaying = false;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Previous");
        }
    }
}
