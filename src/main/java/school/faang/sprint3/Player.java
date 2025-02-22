package school.faang.sprint3;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Player {
    private static final List<String> MUSICS = List.of("song1", "song2", "song3");
    private static final String LOG_FORM = "{} музыку {}";
    private static final String PLAY = "Включаем";
    private static final String PAUSE = "Выключаем";
    private static final String NEXT = "Включаем следующую";
    private static final String PREVIOUS = "Включаем предыдущую";

    private final Object lock = new Object();
    private final int maxIndex = MUSICS.size() - 1;
    private int indexOfTrack;
    private String track;
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                initTrack();
                isPlaying = true;
                log.info(LOG_FORM, PLAY, track);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                log.info(LOG_FORM, PAUSE, track);
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            changeTrack(indexOfTrack, 1);
            log.info(LOG_FORM, NEXT, track);
        }
    }

    public void previous() {
        synchronized (lock) {
            changeTrack(maxIndex + indexOfTrack, -1);
            log.info(LOG_FORM, PREVIOUS, track);
        }
    }

    private void initTrack() {
        if (track == null) {
            track = MUSICS.get(0);
            indexOfTrack = 0;
        }
    }

    private void changeTrack(int start, int inc) {
        indexOfTrack = (start + inc) % maxIndex;
        track = MUSICS.get(indexOfTrack);
    }
}
