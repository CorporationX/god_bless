package school.faangSprint3.t19;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
public class RocketLaunch {
    private static final int SLEEP_TIME = 1000;
    private final String name;
    private final LocalDateTime launchTime;

    public void launch() {
        log.debug("Начинаем подготовку к запуску ракеты: {}",name);
        log.debug("Запланированное время запуска: {}",launchTime);
        try {
            log.info("Инициализация запуска ракеты {}. Ожидание {} мс...", name, SLEEP_TIME);
            Thread.sleep(SLEEP_TIME);
            LocalDateTime actualLaunchTime = LocalDateTime.now();
            log.info("Ракета {} успешно запущена в {}", name, actualLaunchTime);
            long timeDifference = java.time.Duration.between(launchTime, actualLaunchTime).toMillis();
            log.debug("Отклонение от запланированного времени запуска: {} мс", timeDifference);
        } catch (InterruptedException e) {
            log.error("Критическая ошибка при запуске ракеты {}", name, e);
            log.debug("Детали прерванного запуска - Запланированное время: {}, Фактическое время: {}",
                    launchTime, LocalDateTime.now());
            Thread.currentThread().interrupt();
        }
    }
}