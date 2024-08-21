package spotify;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class Player {
    private final Object lock;
    @Getter
    private boolean isPlaying = false;
    @Getter
    private List<String> songs;
    private int currentSong = 0;

    public Player(@NonNull Object lock, @NonNull List<String> songs) {
        if (songs.isEmpty()) {
            throw new IllegalArgumentException("Can't play empty list of songs");
        }
        this.lock = lock;
        this.songs = songs;
    }

    public void setSongs(@NonNull List<String> songs) {
        if (songs.isEmpty()) {
            throw new IllegalArgumentException("Can't play empty list of songs");
        }
        this.songs = songs;
    }

    public void play() {
        synchronized (lock) {
            System.out.println("Play");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Pause");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            currentSong = (currentSong + 1) % songs.size();
            System.out.println("Current song : " + getCurrentSong());
        }
    }

    public void previous() {
        synchronized (lock) {
            currentSong = (currentSong + (songs.size() - 1)) % songs.size();
            System.out.println("Current song : " + getCurrentSong());
        }
    }

    public String getCurrentSong() {
        return songs.get(currentSong);
    }
}
