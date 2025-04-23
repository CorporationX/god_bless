package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Player {

    private static final long TRACK_CHANGE_TIMEOUT_MILLIS = 500;

    private final Object lock = new Object();
    private final List<String> tracks = List.of(
            "Led Zeppelin – Stairway to Heaven",
            "Queen – Bohemian Rhapsody",
            "Pink Floyd – Comfortably Numb",
            "The Rolling Stones – Paint It Black",
            "AC/DC – Back in Black",
            "Nirvana – Smells Like Teen Spirit",
            "The Beatles – Come Together",
            "Deep Purple – Smoke on the Water",
            "Metallica – Nothing Else Matters",
            "Guns N’ Roses – Sweet Child O’ Mine"
    );
    private int songIndex;
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("'{}' already playing", tracks.get(songIndex));
            } else {
                isPlaying = true;
                log.info("press play - '{}' playing", tracks.get(songIndex));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("'{}' already on pause", tracks.get(songIndex));
            } else {
                isPlaying = false;
                log.info("press pause - '{}' paused", tracks.get(songIndex));
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("skipping '{}' track", tracks.get(songIndex));
            increaseSongIndex();
            changeTrack();
            isPlaying = true;
            log.info("next song '{}' starts playing", tracks.get(songIndex));
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("select previous '{}'", tracks.get(songIndex));
            decreaseSongIndex();
            changeTrack();
            isPlaying = true;
            log.info("previous song '{}' starts playing", tracks.get(songIndex));
        }
    }

    private void changeTrack() {
        try {
            Thread.sleep(TRACK_CHANGE_TIMEOUT_MILLIS);
        } catch (InterruptedException e) {
            log.info("Thread interrupted!!!");
            Thread.currentThread().interrupt();
        }
    }

    private void increaseSongIndex() {
        songIndex++;
        if (songIndex == tracks.size()) {
            songIndex = 0;
        }
    }

    private void decreaseSongIndex() {
        songIndex--;
        if (songIndex < 0) {
            songIndex = tracks.size() - 1;
        }
    }
}
