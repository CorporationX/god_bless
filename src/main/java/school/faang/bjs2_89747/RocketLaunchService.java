package school.faang.bjs2_89747;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RocketLaunchService {
    private static final int TIME_SLEEP = 1000;
    private static final int CORE_POOL_SIZE = 3;

    public void launch(RocketLaunch rocketLaunch) {
        try {
            Thread.sleep(TIME_SLEEP);
            log.info("The launch {} took place in {}", rocketLaunch.getName(), rocketLaunch.getLaunchTime());
        } catch (InterruptedException e) {
            log.error("startup {} interrupted! Time - {}", rocketLaunch.getName(), rocketLaunch.getLaunchTime(), e);
        }
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        //  newScheduledThreadPool - не думал, что четко выполнит все запуски.
        //  Думал запорит тайминги запуска, а нет
        //  Правда если ставить одинаковое время,то бывает проблемы, не одновременно запускает
        // Но мне кажется так везде будет, если потоков будет меньше, чем запусков
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        launches.forEach((rocketLaunch) -> {
            LocalDateTime localDateTime = rocketLaunch.getLaunchTime();
            long timeForLaunch = Timestamp.valueOf(localDateTime).getTime() - System.currentTimeMillis();
            scheduledPool.schedule(() -> launch(rocketLaunch),
                    timeForLaunch,
                    TimeUnit.MILLISECONDS);
            log.info("launch {} scheduled in {}", rocketLaunch.getName(), rocketLaunch.getLaunchTime());
        });

        scheduledPool.shutdown();
        try {
            if (!scheduledPool.awaitTermination(5, TimeUnit.MINUTES)) {
                scheduledPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledPool.shutdownNow();
        }
    }
}
