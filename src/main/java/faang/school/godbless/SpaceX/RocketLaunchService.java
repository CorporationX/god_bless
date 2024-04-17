package faang.school.godbless.SpaceX;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RocketLaunchService {
    public void planRocketLaunches(List<RocketLaunch> launches) {
        try {
            ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

            for (RocketLaunch launch : launches) {
                LocalDateTime currentTime = LocalDateTime.now();
                LocalDateTime launchTime = launch.getTime();
                long delay = Duration.between(currentTime, launchTime).toMillis();

                pool.schedule(launch::launch, delay, TimeUnit.MILLISECONDS);
            }

            pool.shutdown();
            while (!pool.awaitTermination(10, TimeUnit.MINUTES)) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
