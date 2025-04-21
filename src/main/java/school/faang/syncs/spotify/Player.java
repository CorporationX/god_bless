package school.faang.syncs.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private String currentSong = "Song 1";
    private final List<String> playList = List.of("Song 1", "Song 2", "Song 3", "Song 4", "Song 5", "Song 6");

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Playing current song: {}", currentSong);
            } else {
                log.info("Song is already playing!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Paused current song: {}", currentSong);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentSong = getSong(1);
            log.info("Skipped to: {}", currentSong);
        }
    }

    public void previous() {
        synchronized (lock) {
            currentSong = getSong(-1);
            log.info("Returned to: {}", currentSong);
        }
    }

    private String getSong(int shift) {
        int currentSongIdx = playList.indexOf(currentSong);
        int startIdxOfPlayList = 0;
        int endIdxOfPlayList = playList.size() - 1;
        int nextIdxSong = currentSongIdx + shift > endIdxOfPlayList ? startIdxOfPlayList :
                currentSongIdx + shift < startIdxOfPlayList ? endIdxOfPlayList : currentSongIdx + shift;
        return playList.get(nextIdxSong);
    }
}
