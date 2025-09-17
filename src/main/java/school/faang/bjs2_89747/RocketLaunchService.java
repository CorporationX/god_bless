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


    public void launch(RocketLaunch rocketLaunch) {
        try {
            Thread.sleep(1000);
            log.info("The launch {} took place in {}", rocketLaunch.getName(), rocketLaunch.getLaunchTime());
        } catch (InterruptedException e) {
            log.error("startup {} interrupted! Time - {}", rocketLaunch.getName(), rocketLaunch.getLaunchTime(), e);
        }
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        // не знаю подходящее ли использование newScheduledThreadPool, ибо выполняет задачу после задержки
        // как в этой задаче, но  по условию требуется newSingleThreadExecutor(), как по мне, он тут не нужен
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(launches.size());

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
