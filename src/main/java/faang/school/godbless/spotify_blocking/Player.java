package faang.school.godbless.spotify_blocking;

import lombok.Getter;

import java.util.List;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    private final List<String> playList = List.of("track 1", "track 2", "track 3", "track 4", "track 5");

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
