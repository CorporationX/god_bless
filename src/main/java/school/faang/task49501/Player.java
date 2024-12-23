package school.faang.task49501;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    @Getter
    private final AtomicInteger countThreads = new AtomicInteger();

    public void play() {
        synchronized (lock) {
            countThreads.incrementAndGet();
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
            countThreads.incrementAndGet();
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка поставлена на паузу");
            } else {
                log.info("Музыка уже на паузе ");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            countThreads.incrementAndGet();
            log.info(" Трек пропущен .");
        }
    }

    public void previous() {
        synchronized (lock) {
            countThreads.incrementAndGet();
            log.info(" Вернулись к предыдущему треку .");
        }
    }
}
