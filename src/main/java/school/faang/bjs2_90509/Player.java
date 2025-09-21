package school.faang.bjs2_90509;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Already playing");
            } else {
                System.out.println("Start playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Stop playing");
            } else {
                System.out.println("Alreaty stopping");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Go back to the previous track");
        }
    }
}
