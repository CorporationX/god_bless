package school.faang.spotify;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
@ToString
public class Player {
    private final Object lock = new Object();
    private StatusPlayer isPlaying;
    private final Music music;

    public Player(Music music) {
        this.music = music;
    }

    public void play() {
        synchronized (lock) {
            log.info("PLAY");
            if (Objects.equals(isPlaying, StatusPlayer.PLAY)) {
                log.info("Статус после нажатия PLAY остался прежним: {}", this.getIsPlaying());
            } else {
                isPlaying = StatusPlayer.PLAY;
                log.info("Статус изменился после нажатия PLAY: {}", this.getIsPlaying());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            log.info("PAUSE");
            if (Objects.equals(isPlaying, StatusPlayer.PAUSE)) {
                log.info("Статус после нажатия PAUSE остался прежним: {}", this.getIsPlaying());
            } else {
                isPlaying = StatusPlayer.PAUSE;
                log.info("Статус изменился после нажатия PAUSE: {}", this.getIsPlaying());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("SKIP");
            switchUpBySong();
            if (Objects.equals(isPlaying, StatusPlayer.PLAY)) {
                log.info("Статус после нажатия SKIP остался прежним: {}", this.getIsPlaying());
            } else {
                isPlaying = StatusPlayer.PLAY;
                log.info("Статус изменился после нажатия SKIP: {}", this.getIsPlaying());
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("PREVIOUS");
            switchDownBySong();
            if (Objects.equals(isPlaying, StatusPlayer.PLAY)) {
                log.info("Статус после нажатия PREVIOUS остался прежним: {}", this.getIsPlaying());
            } else {
                isPlaying = StatusPlayer.PLAY;
                log.info("Статус изменился после нажатия PREVIOUS: {}", this.getIsPlaying());
            }
        }
    }

    public void switchUpBySong() {
        music.incrementIndex();
        if (music.getCurrentIndex() >= music.getMusic().size()) {
            music.setCurrentIndex(0);
        }
    }

    public void switchDownBySong() {
        music.decrementIndex();
        if (music.getCurrentIndex() < 0) {
            music.setCurrentIndex(music.getMusic().size() - 1);
        }
    }
}