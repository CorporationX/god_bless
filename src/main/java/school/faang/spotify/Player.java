package school.faang.spotify;

import lombok.Getter;
import lombok.Synchronized;

public class Player {
    private final Object lock = new Object();
    @Getter
    private boolean isPlaying = false;

    @Synchronized("lock")
    public void play() {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println("The music is playing.");
        } else {
            System.out.println("The music is already playing.");
        }
    }

    @Synchronized("lock")
    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("The music is paused.");
        } else {
            System.out.println("The music is already on pause.");
        }
    }

    @Synchronized("lock")
    public void skip() {
        System.out.println("Track skipped.");
    }

    @Synchronized("lock")
    public void previous() {
        System.out.println("Went back to the previous track.");
    }
}
