package school.faang.spacex;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "SpaceCenter")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpaceCenter {

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        var executor = Executors.newSingleThreadExecutor();
        try {
            for (var rocket : launches) {
                var delay = rocket.getLaunchTime() - System.currentTimeMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executor.execute(rocket::launch);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                executor.shutdownNow();
            }
        }
    }
}
