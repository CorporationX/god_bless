package school.faang.bjs2_81270;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RocketLaunchManager {
    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            for (RocketLaunch rocket : launches) {
                log.info("Начат запуск ракеты {}", rocket.name());
                Thread.sleep(rocket.launchTime());
                executor.execute(rocket::launch);
            }

            executor.shutdown();

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Еще не все задачи завершены");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Еще не все задачи завершены");
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
        log.info("Все задачи завершены");
    }
}
