package school.faang.sprint3;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private final List<String> musics = List.of("song1", "song2", "song3");
    private final int maxIndex = musics.size() - 1;
    private int indexOfTrack;
    private String track;
    private boolean isPlaying;

    public  void play() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("Включаем музыку");
                initTrack();
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Выключаем музыку");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Включаем следующую музыку");
            changeTrack(indexOfTrack, 1);
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Включаем предыдущую музыку");
            changeTrack(maxIndex + indexOfTrack, -1);
        }
    }

    private void initTrack() {
        if (track == null) {
            track = musics.get(0);
            indexOfTrack = 0;
        }
    }

    private void changeTrack(int start, int inc) {
        indexOfTrack = start + inc % maxIndex;
        track = musics.get(indexOfTrack);
    }
}
