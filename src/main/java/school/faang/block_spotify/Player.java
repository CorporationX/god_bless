package school.faang.block_spotify;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class Player {
    private final List<Integer> tracks;
    private final Object lock = new Object();
    private boolean isPlaying;
    private int currentTrack;

    public Player(List<Integer> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        log.debug("play() executing Thread = {}", Thread.currentThread().getName());
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing track {} by Thread {}", tracks.get(currentTrack), Thread.currentThread().getName());
                try {
                    Thread.sleep(500); //имитируем проигрыш трека
                } catch (InterruptedException e) {
                    log.error("Thread interrupted", e);
                    Thread.currentThread().interrupt();
                }
                currentTrack++;
                log.info("Current Track after playing - {}", currentTrack);
            } else {
                log.debug("Can't play track as playing already");
            }
        }
    }

    public void pause() {
        log.debug("pause() executing Thread = {}", Thread.currentThread().getName());
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Pausing track {}", tracks.get(currentTrack));
            } else {
                log.debug("Can't pause track as paused already");
            }
        }
    }

    public void skip() {
        log.debug("skip() executing Thread = {}", Thread.currentThread().getName());
        boolean wasPlaying = false;
        synchronized (lock) {
            if (isPlaying) {
                wasPlaying = true;
                isPlaying = false;
                log.info("Skipping track {}", tracks.get(currentTrack));
                currentTrack++;
                log.info("currentTrack - {}", currentTrack);
            } else {
                log.debug("Can't skip track as paused");
            }
        }
        if (wasPlaying) {
            log.info("Calling play() method");
            play();
        }
    }

    public void previous() {
        log.debug("previous() executing Thread = {}", Thread.currentThread().getName());
        boolean wasPlaying = false;
        synchronized (lock) {
            if (isPlaying) {
                wasPlaying = true;
                isPlaying = false;
                currentTrack--;
                log.info("Getting to the previous track {}", tracks.get(currentTrack));
            } else {
                log.debug("Can't play previous track as paused");
            }
        }
        if (wasPlaying) {
            log.info("Calling play() method");
            play();
        }
    }
}
