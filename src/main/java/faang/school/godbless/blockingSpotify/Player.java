package faang.school.godbless.blockingSpotify;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Playing music");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pausing music");
                isPlaying = false;
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to next track");
            } else {
                System.out.println("Impossible to miss when music is paused");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipping to the previous track");
            } else {
                System.out.println("Unable to skip to previous track when music is paused");
            }
        }
    }
}
