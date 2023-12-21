package faang.school.godbless.multithreading.synchronizedPractice.blockedSpotify;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println("Now player is playing");
            isPlaying = true;
            System.out.println("Is Playing : - " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Now player is pause");
            isPlaying = false;
            System.out.println("Is Playing : - " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Now player is playing, track skipped");
            isPlaying = true;
            System.out.println("Is Playing : - " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Now player is playing, go to previous track");
            isPlaying = true;
            System.out.println("Is Playing : - " + isPlaying);
        }
    }
}

