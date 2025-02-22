package school.faang.sprint3.bjs2_61779;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Player {
    private static final Logger log = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info(String.format("[%s] [Поток: %d] Музыка воспроизводится.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId()));
            } else {
                log.info(String.format("[%s] [Поток: %d] Музыка уже играет.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId()));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info(String.format("[%s] [Поток: %d] Музыка поставлена на паузу.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId()));
            } else {
                log.info(String.format("[%s] [Поток: %d] Музыка уже на паузе.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId()));
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info(String.format("[%s] [Поток: %d] Трек пропущен.%n",
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    Thread.currentThread().getId()));
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info(String.format("[%s] [Поток: %d] Вернулись к предыдущему треку.%n",
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    Thread.currentThread().getId()));
        }
    }
}
