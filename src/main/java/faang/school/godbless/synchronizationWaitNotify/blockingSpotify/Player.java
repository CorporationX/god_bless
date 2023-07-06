package faang.school.godbless.synchronizationWaitNotify.blockingSpotify;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is already playing");
            } else {
                System.out.println("Starting to play music...");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music is paused");
                isPlaying = false;
            } else {
                System.out.println("Music has already been paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The next music starting to play");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("The previous music starting to play");
            isPlaying = true;
        }
    }
}
