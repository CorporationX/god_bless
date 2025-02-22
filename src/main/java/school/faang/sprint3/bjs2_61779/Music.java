package school.faang.sprint3.bjs2_61779;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final Thread playThread = new Thread(() -> {
            try {
                player.play();
            } catch (Exception e) {
                log.error(String.format("[%s] [Поток: %d] Поток запуска был прерван: %s.%n",
                        LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId(),
                        e.getMessage()));
                Thread.currentThread().interrupt();
            }
        });
        final Thread pauseThread = new Thread(() -> {
            try {
                player.pause();
            } catch (Exception e) {
                log.error(String.format("[%s] [Поток: %d] Поток остановки был прерван: %s.%n",
                        LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId(),
                        e.getMessage()));
                Thread.currentThread().interrupt();
            }
        });
        final Thread skipThread = new Thread(() -> {
            try {
                player.skip();
            } catch (Exception e) {
                log.error(String.format("[%s] [Поток: %d] Поток пропуска был прерван: %s.%n",
                        LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId(),
                        e.getMessage()));
                Thread.currentThread().interrupt();
            }
        });
        final Thread previousThread = new Thread(() -> {
            try {
                player.previous();
            } catch (Exception e) {
                log.error(String.format("[%s] [Поток: %d] Поток возврата был прерван:: %s.%n",
                        LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId(),
                        e.getMessage()));
                Thread.currentThread().interrupt();
            }
        });

        Thread playbackThreads = new Thread(() -> {
            playThread.start();
            pauseThread.start();
        });
        Thread navigationThreads = new Thread(() -> {
            skipThread.start();
            previousThread.start();
        });
        playbackThreads.start();
        navigationThreads.start();

        try {
            playbackThreads.join();
            navigationThreads.join();
        } catch (InterruptedException e) {
            log.error(String.format("[%s] [Поток: %d] Основной поток был прерван: %s.%n",
                    LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    Thread.currentThread().getId(),
                    e.getMessage()));
            Thread.currentThread().interrupt();
        }
    }
}
