package school.faang.task49501;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info(" Музыка воспроизводится .");
            } else {
                log.info(" Музыка уже играет .");
            }
        }

    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info(" Трек пропущен .");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info(" Вернулись к предыдущему треку .");
        }
    }
}
