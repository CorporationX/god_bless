package school.faang.sprint3.task_49248;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class Player {

    private final List<String> playList;
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int indexCurrentSong = 0;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                throw new UnsupportedOperationException("The player is already playing !");
            }
            isPlaying = true;
            log.info("Now the song {} is playing", playList.get(indexCurrentSong % playList.size()));
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                throw new UnsupportedOperationException("The player is already on pause !");
            }
            isPlaying = false;
            log.info("The song {} has been paused", playList.get(indexCurrentSong % playList.size()));
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Skip the song {}", playList.get(indexCurrentSong % playList.size()));
            indexCurrentSong++;
        }
    }

    public void previous() {
        synchronized (lock) {
            indexCurrentSong--;
            if (indexCurrentSong < 0) {
                indexCurrentSong = playList.size() - 1;
            }
            log.info("Go back to the song {}", playList.get(indexCurrentSong % playList.size()));
        }
    }
}
