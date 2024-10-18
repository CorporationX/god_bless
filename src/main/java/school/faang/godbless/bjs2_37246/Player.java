package school.faang.godbless.bjs2_37246;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;
    private List<Track> tracks;
    int currentTrackIndex = 0;

    public Player(@NonNull List<Track> tracks) {
        if (tracks.isEmpty()) {
            throw new IllegalArgumentException("Empty tracks list is not allowed");
        }
        this.tracks = tracks;
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing track " + tracks.get(currentTrackIndex).getName());
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
            System.out.println("Skipping to next track");
            currentTrackIndex = (currentTrackIndex + 1) % tracks.size();
            printCurrentTrack();
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Going to previous track");
            currentTrackIndex = Math.floorMod(currentTrackIndex - 1, tracks.size());
            printCurrentTrack();
        }
    }

    private void printCurrentTrack() {
        System.out.println("The current tack is " + tracks.get(currentTrackIndex).getName());
    }
}
