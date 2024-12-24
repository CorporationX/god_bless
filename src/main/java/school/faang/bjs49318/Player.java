package school.faang.bjs49318;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Player {
    private final Object lock;
    @Getter
    private boolean isPlaying;
    private final List<String> songs;
    private int currentSong;

    public Player(List<String> songs) {
        this.songs = songs;
        isPlaying = true;
        lock = new Object();
        currentSong = 0;
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Switched to pause song by {}, current song {}",
                        Thread.currentThread().getName(), currentSong);
            }
        }
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Switched to play song by {}, current song {}", Thread.currentThread().getName(), currentSong);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (currentSong < songs.size() - 1) {
                currentSong++;
                log.info("Switched to next song by {}, current song {}", Thread.currentThread().getName(), currentSong);
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentSong > 0) {
                currentSong--;
                log.info("Switched to previous song by {}, current song {}",
                        Thread.currentThread().getName(), currentSong);
            }
        }
    }

    public void playSong() throws InterruptedException {
        int playedSong = currentSong;
        String song = songs.get(currentSong);

        for (int i = 0; true; i++) {
            if (playedSong != currentSong) {
                playSong();
                return;
            }
            while (!isPlaying) {
                Thread.sleep(100);
            }
            if (i >= song.length()) {
                if (currentSong == songs.size() - 1) {
                    return;
                }
                skip();
                playSong();
                return;
            }
            log.info("Playing song {} at second: {}", song, i);
            Thread.sleep(1500);
        }
    }
}
