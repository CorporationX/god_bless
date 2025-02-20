package school.faang.BJS2_61810;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private static final String MUSIC_ALREADY_PLAYING = "The music is already playing";
    private static final String MUSIC_PLAYING = "The music is playing";
    private static final String MUSIC_PAUSED = "The music is paused";
    private static final String MUSIC_ALREADY_PAUSED = "The music has already been paused";
    private static final String MUSIC_SKIP = "The track is missing";
    private static final String MUSIC_PREVIOUS = "We went back to the previous track";
    private final Object lock = (Object) 1;
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info(MUSIC_ALREADY_PLAYING);
            } else {
                isPlaying = true;
                log.info(MUSIC_PLAYING);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info(MUSIC_ALREADY_PAUSED);
            } else {
                isPlaying = false;
                log.info(MUSIC_PAUSED);
            }
        }

    }

    public void skip() {
        synchronized (lock) {
            log.info(MUSIC_SKIP);
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info(MUSIC_PREVIOUS);
        }
    }

}
