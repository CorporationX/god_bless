package faang.school.godbless.mt.spotify;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Player {
    private final Object lock = new Object();
    @Getter
    private int trackNumber = 0;
    @Getter
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("The player is already playing");
            } else {
                System.out.println("The player changes the status to playing");
                isPlaying = true;
            }

        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("The player is already paused");
            } else {
                System.out.println("The player changes the status to pause");
                isPlaying = false;
            }

        }
    }

    public void skip() {
        synchronized (lock) {
            trackNumber++;
            isPlaying = true;
            System.out.println("The player skipped the track");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (trackNumber > 0) {
                trackNumber--;
                System.out.println("The player returned the previous track");
            }
            isPlaying = true;
        }
    }
}
