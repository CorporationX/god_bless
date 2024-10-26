package school.faangSprint3.t19;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RocketLaunchSimulator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();

        log.info("Инициализация симулятора запусков ракет");

        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        log.info("Добавлено {} ракет в очередь запуска", launches.size());
        launches.forEach(launch ->
                log.debug("Запланирован запуск ракеты: {}, время старта: {}",
                        launch.getName(),
                        launch.getLaunchTime().format(FORMATTER))
        );

        long startTime = System.currentTimeMillis();

        log.info("Начало планирования запусков: {}", LocalDateTime.now().format(FORMATTER));

        planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();
        log.info("Планирование запусков завершено");
        log.info("\n Общее время выполнения: {} миллисекунд", endTime - startTime);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        log.debug("Создан пул потоков: {}", executor);
        launches.sort(Comparator.comparing(RocketLaunch::getLaunchTime));
        log.debug("Запуски отсортированы по времени старта");

        try {
            for (RocketLaunch launch : launches) {
                long delay = Math.max(0, launch.getLaunchTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() - System.currentTimeMillis());
                log.debug("Планирование запуска ракеты: {}, задержка: {} мс",
                        launch.getName(), delay);

                executor.execute(() -> {
                    try {
                        if (delay > 0) {
                            log.debug("Ожидание {} мс перед запуском ракеты: {}",
                                    delay, launch.getName());
                            Thread.sleep(delay);
                        } else {
                            log.warn("Нулевая или отрицательная задержка для ракеты: {}, " +
                                    "запуск произойдет немедленно", launch.getName());
                        }
                        log.info("Начало запуска ракеты: {} в {}",
                                launch.getName(),
                                LocalDateTime.now().format(FORMATTER));
                        launch.launch();
                        log.info("Успешный запуск ракеты: {}", launch.getName());
                    } catch (InterruptedException e) {
                        log.error("Прерван запуск ракеты: {}", launch.getName(), e);
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } catch (Exception e) {
            log.error("Ошибка при планировании запусков", e);
        } finally {
            log.debug("Начало завершения работы пула потоков");
            executor.shutdown();
            try {
                boolean terminated = executor.awaitTermination(1, TimeUnit.HOURS);
                if (terminated) {
                    log.info("Пул потоков успешно завершил работу");
                } else {
                    log.warn("Превышено время ожидания завершения пула потоков");
                }
            } catch (InterruptedException e) {
                log.error("Прервано ожидание завершения пула потоков", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}