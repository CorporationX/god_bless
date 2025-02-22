package spotify;

import java.util.List;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int currentTrack = 0;
    private final List<String> playlist;

    public Player(List<String> playlist) {
        this.playlist = playlist;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Playing: " + playlist.get(currentTrack));
            } else {
                System.out.println("Music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Paused: " + playlist.get(currentTrack));
            } else {
                System.out.println("Music is already paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (currentTrack < playlist.size() - 1) {
                currentTrack++;
                System.out.println("Skipping to next track: " + playlist.get(currentTrack));
            } else {
                currentTrack = 0;
                System.out.println("Skipping to next track: " + playlist.get(currentTrack));
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentTrack > 0) {
                currentTrack--;
                System.out.println("Going back to previous track: " + playlist.get(currentTrack));
            } else {
                System.out.println("Can't go back.");
            }
        }
    }
}
