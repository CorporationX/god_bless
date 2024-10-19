package school.faang.spotify;

import lombok.Getter;

@Getter
public class Player implements PlayerI {
    private final Object lock = new Object();
    private Boolean isPlaying;

    @Override
    public void play() {
        synchronized (lock) {
            this.isPlaying = true;
        }
    }

    @Override
    public void pause() {
        synchronized (lock) {
            this.isPlaying = false;
        }
    }

    @Override
    public void previous() {

    }

    @Override
    public void skip() {

    }
}
