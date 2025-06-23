package school.faang.spotify;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Play music");
            } else {
                System.out.println("Music already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Playing music is stopped");
            } else {
                System.out.println("Music not playing");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip music");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track");
        }
    }

}
