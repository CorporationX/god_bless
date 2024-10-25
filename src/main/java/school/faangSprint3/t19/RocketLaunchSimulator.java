package school.faangSprint3.t19;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RocketLaunchSimulator {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();

        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        long startTime = System.currentTimeMillis();

        log.info("Начало планирования запусков: {}", LocalDateTime.now());

        planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();

        log.info("\n Общее время выполнения: {} миллисекунд", endTime - startTime);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            launches.sort(Comparator.comparing(RocketLaunch::getLaunchTime));

            for (RocketLaunch launch : launches) {
                long delay = Math.max(0, launch.getLaunchTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() - System.currentTimeMillis());

                executor.execute(() -> {
                    try {
                        if (delay > 0) {
                            Thread.sleep(delay);
                        }
                        launch.launch();
                    } catch (InterruptedException e) {
                        RocketLaunchSimulator.log.error("Ошибка планирования: {}", e.getMessage());
                    }
                });
            }
        } finally {
            executor.shutdown();
            try {
                executor.awaitTermination(1, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                RocketLaunchSimulator.log.error("Ожидание прервано: {}", e.getMessage());
            }
        }
    }
}