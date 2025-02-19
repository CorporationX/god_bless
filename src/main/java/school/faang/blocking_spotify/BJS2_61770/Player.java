package school.faang.blocking_spotify.BJS2_61770;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Playing");
            } else {
                System.out.println("the music's already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Paused");
            } else {
                System.out.println("the music is already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("skip track");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous track");
        }
    }
}
