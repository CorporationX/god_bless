package school.faang.task_49189;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@NoArgsConstructor
public class Player {
    private final Object lock = new Object();
    private final List<MusicTrack> playlist = new ArrayList<>();
    private boolean isPlaying = false;
    private MusicTrack actualTrack;
    private Duration actualTrackDuration;

    public Player(List<MusicTrack> musicPlaylist) {
        changePlaylist(musicPlaylist);
    }

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                return;
            }
            isPlaying = true;
        }

        while (isPlaying) {
            synchronized (lock) {
                actualTrackDuration = actualTrackDuration.minusSeconds(1);
                if (!actualTrackDuration.isZero()) {
                    log.info("Playing {} {}:{}/{}:{}", actualTrack.name(),
                            actualTrackDuration.toMinutesPart(),
                            actualTrackDuration.toSecondsPart(),
                            actualTrack.duration().toMinutesPart(),
                            actualTrack.duration().toSecondsPart());
                } else {
                    skip();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Player on paused");
                lock.notifyAll();
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            int currentIndex = playlist.indexOf(actualTrack);
            if (currentIndex + 1 < playlist.size()) {
                setActualTrack(playlist.get(currentIndex + 1));
            } else {
                isPlaying = false;
                setActualTrack(playlist.get(0));
            }
            log.info("Next track - {}", actualTrack.name());
        }
    }

    public void previous() {
        synchronized (lock) {
            int currentIndex = playlist.indexOf(actualTrack);
            if (currentIndex > 0) {
                setActualTrack(playlist.get(currentIndex - 1));
            }
            log.info("Previous track - {}", actualTrack.name());
        }
    }

    public void changePlaylist(List<MusicTrack> musicPlaylist) {
        synchronized (lock) {
            playlist.clear();
            playlist.addAll(Optional.ofNullable(musicPlaylist)
                    .orElseThrow(() -> new IllegalArgumentException("Playlist cannot be null"))
                    .stream()
                    .filter(Objects::nonNull)
                    .toList()
            );
            if (!playlist.isEmpty()) {
                setActualTrack(playlist.get(0));
            }
        }
    }

    private void setActualTrack(MusicTrack track) {
        actualTrack = track;
        actualTrackDuration = track.duration();
    }
}
