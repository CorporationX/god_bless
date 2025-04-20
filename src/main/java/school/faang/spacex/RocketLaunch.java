package school.faang.spacex;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RocketLaunch {
    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            log.info("Ракета '{}' успешно запущена!", name);
        } catch (InterruptedException e) {
            log.warn("Запуск ракеты '{}' прерван!", name);
            Thread.currentThread().interrupt();
        }
    }
}
