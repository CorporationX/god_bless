package school.faangSprint3.t19;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
public class RocketLaunch {
    private final String name;
    private final LocalDateTime launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            log.info("Ракета {} запущена в {}", name, LocalDateTime.now());
        } catch (InterruptedException e) {
            log.error("Запуск прерван: {}", e.getMessage());
        }
    }
}