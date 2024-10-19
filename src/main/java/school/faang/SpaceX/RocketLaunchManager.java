package school.faang.SpaceX;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RocketLaunchManager {
  public static void planRocketLaunches(List<RocketLaunch> launches) {
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    launches.forEach(launch -> scheduledExecutorService.schedule(
        launch::launch,
        launch.getLaunchTime().getTime() - System.currentTimeMillis(),
        TimeUnit.MILLISECONDS
    ));

    scheduledExecutorService.shutdown();

    try {
      if (scheduledExecutorService.awaitTermination(5, TimeUnit.MINUTES)) {
        System.out.println("все ракеты заупщены\n");
      } else {
        scheduledExecutorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      scheduledExecutorService.shutdownNow();
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
