package school.faang.spotifyblocker;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing music...");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Song paused.");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing next song...");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing previous song...");
        }
    }
}
