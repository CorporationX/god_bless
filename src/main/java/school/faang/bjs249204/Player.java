package school.faang.bjs249204;

import lombok.Getter;

@Getter
public class Player {

    private final Object look = new Object();
    private String isPlaying;

    public void play() {
        synchronized (look) {
            isPlaying = "Player is playing";
        }
    }

    public void pause() {
        synchronized (look) {
            isPlaying = "Player is paused";
        }
    }

    public void skip() {
        synchronized (look) {
            isPlaying = "Player is skipping";
        }
    }

    public void previous() {
        synchronized (look) {
            isPlaying = "Player is playing previous";
        }
    }
}
