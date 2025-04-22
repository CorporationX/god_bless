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
    private int songIndex = 4;
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("press play - {} playing", tracks.get(songIndex));
        }
    }

    public synchronized void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("press pause - {} paused", tracks.get(songIndex));
        }
    }

    public synchronized void skip() {
        synchronized (lock) {
            log.info("skipping {} track", tracks.get(songIndex));
            songIndex++;
            isPlaying = true;
            log.info("next song - {}", tracks.get(songIndex));
            sleep(TRACK_CHANGE_TIMEOUT_MILLIS);
        }
    }

    public synchronized void previous() {
        synchronized (lock) {
            log.info("select previous {}", tracks.get(songIndex));
            songIndex--;
            isPlaying = true;
            log.info("previous song - {}", tracks.get(songIndex));
            sleep(TRACK_CHANGE_TIMEOUT_MILLIS);
        }
    }

    private void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            log.info("Thread interrupted!!!");
            Thread.currentThread().interrupt();
        }
    }
}
