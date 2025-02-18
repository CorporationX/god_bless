package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.utils.ValidationUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RockerLaunchService {
    private static final int TIMEOUT_MINUTES = 10;
    private static final Logger logger = LoggerFactory.getLogger(RockerLaunchService.class);

    public static void planRockerLaunches(List<RocketLaunch> launches) {
        ValidationUtil.isValidList(launches, "launch");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        launches.sort(Comparator.comparing(RocketLaunch::getStartTime));

        for (RocketLaunch rocketLaunch : launches) {
            long delay = Duration.between(LocalDateTime.now(), rocketLaunch.getStartTime()).toMillis();
            if (delay < 0) {
                throw new PastLaunchException("A rocket launch can't be planned in the past.");
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            executorService.submit(rocketLaunch::launch);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                logger.error("Not all launches were completed on time.");
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
