package faang.school.godbless.synchronization.spotify;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();

    private boolean playing;

    public void play() {
        synchronized (lock) {
            playing = true;
            System.out.println("Play");
            System.out.println("isPlaying: " + isPlaying());
        }
    }

    public void pause() {
        synchronized (lock) {
            playing = false;
            System.out.println("Pause");
            System.out.println("isPlaying: " + isPlaying());
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous");
        }
    }
}
