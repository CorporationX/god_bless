package school.faang.sprint_3.task_48484;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Slf4j
public class RocketLaunch {
    private static final int DELAY = 1000;
    String name;
    LocalDateTime launchTime;

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            for (RocketLaunch rocket : launches) {
                long delay = Duration.between(LocalDateTime.now(), rocket.launchTime).toMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executor.submit(() -> {
                    try {
                        rocket.launch();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Планирование запуска прервано");
        } finally {
            executor.shutdown();
        }
    }

    private void launch() throws InterruptedException {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван во время задержки");
        }
        log.info("Запущена ракета {}", name);
    }
}
