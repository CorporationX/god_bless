package school.faang.task_48278;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.printf("Ракета %s запускается в %d миллисекунд.\n", name, launchTime);
        } catch (InterruptedException e) {
            log.info("Ошибка при запуске ракеты: " + e.getMessage());
        }
    }

}
