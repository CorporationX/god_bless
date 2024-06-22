package faang.school.godbless.spotify_blocking;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    List<String> tracks = new ArrayList<>();

    public void play(String trackName) throws InterruptedException {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            System.out.println("Music " + trackName + " plays");
        }
    }

    public void pause(String trackName) throws InterruptedException {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Music " + trackName + " paused");
        }
    }

    public void skip(String trackName) throws InterruptedException {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Music " + trackName + " skipped");
        }
    }

    public void previous(String trackName) throws InterruptedException {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Previous music " + trackName + " plays");
        }
    }
}
