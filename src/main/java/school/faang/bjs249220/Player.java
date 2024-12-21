package school.faang.bjs249220;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();

    private boolean isPlaying;

    public Player(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                System.out.println("Music is starting to play");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is playback paused");
                isPlaying = false;
            } else {
                System.out.println("Music is not playing, nothing to pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Song is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Returning to previous song");
        }
    }
}
