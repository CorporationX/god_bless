package school.faang.task_48278;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class RocketLaunch {

    private static final int SLEEP_DURATION = 1000;

    private String name;
    private long launchTime;

    public void launch() {
        try {
            Thread.sleep(SLEEP_DURATION);
            System.out.printf("Ракета %s запускается в %d миллисекунд.\n", name, launchTime);
        } catch (InterruptedException e) {
            log.info("Ошибка при запуске ракеты: " + e.getMessage());
        }
    }

}
