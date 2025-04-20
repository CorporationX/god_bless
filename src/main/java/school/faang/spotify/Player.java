package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int currentTrack = 1;
    private final int totalTracks = 30;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Воспроизведение начато (Трек {})", currentTrack);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Воспроизведение приостановлено");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentTrack = currentTrack < totalTracks ? ++currentTrack : 1;
            log.info("Переход к следующему треку (Трек {})", currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrack = currentTrack > 1 ? --currentTrack : totalTracks;
            log.info("Возврат к предыдущему треку (Трек {})", currentTrack);
        }
    }
}
