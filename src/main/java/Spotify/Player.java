package Spotify;

import lombok.Getter;

import java.util.List;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private final List<String> trackList = List.of("Track1", "Track2", "Track3", "Track4", "Track5");
    private int currentTrackIndex = 0;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Now playing - " + trackList.get(currentTrackIndex));
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (currentTrackIndex == trackList.size() - 1) {
                currentTrackIndex = 0;
            } else {
                currentTrackIndex++;
            }
            System.out.println("Next track - " + trackList.get(currentTrackIndex));
            ;
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentTrackIndex == 0) {
                currentTrackIndex = trackList.size() - 1;
            } else {
                currentTrackIndex--;
            }
            System.out.println("Previous track - " + trackList.get(currentTrackIndex));
        }
    }
}
