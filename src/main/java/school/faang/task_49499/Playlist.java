package school.faang.task_49499;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<String> songs = new ArrayList<>();
    private int currentSong;

    public void addSong(String song) {
        if (songs.contains(song) || song == null) {
            throw new IllegalArgumentException("Song already exist or song equals null");
        }
        songs.add(song);
    }

    public void removeSong(String song) {
        if (!songs.contains(song) || song == null) {
            throw new IllegalArgumentException("Song does not exist");
        }
        songs.remove(song);
    }

    public void getCurrentSong() {
        System.out.println("Now is playing: " + songs.get(currentSong));
    }

    public void next() {
        if (!songs.isEmpty()) {
            currentSong = (currentSong + 1) % songs.size();
        }
    }

    public void previous() {
        if (!songs.isEmpty()) {
            currentSong = (currentSong - 1 + songs.size()) % songs.size();
        }
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }
}
