package faang.school.godbless.spotify;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Object lock = new Object();
    private final List<String> playlist = new ArrayList<>();
    private int currentTrackIdx = 0;
    private boolean isPlaying = false;

    public Player(List<String> playlist) {
        this.playlist.addAll(playlist);
    }

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Player is playing already!");
            } else {
                isPlaying = true;
                System.out.printf("Playing now: '%s'%n", playlist.get(currentTrackIdx));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Player is paused already!");
            } else {
                System.out.println("Paused...");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (currentTrackIdx < playlist.size()) {
                currentTrackIdx++;
                System.out.printf("Skipped track, now playing: '%s'%n", playlist.get(currentTrackIdx));
            } else {
                currentTrackIdx = 0;
                isPlaying = false;
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentTrackIdx > 0) {
                currentTrackIdx--;
                System.out.printf("Previous track, now playing: '%s'%n", playlist.get(currentTrackIdx));
            }
        }
    }
}
