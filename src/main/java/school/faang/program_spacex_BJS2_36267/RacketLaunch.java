package school.faang.program_spacex_BJS2_36267;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
public class RacketLaunch {
    private String name;
    private int launchTime;

    public void launch() {
        final int SLEEP_TIME = 1000;
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread sleep interrupted for rocket: {}", name, e);
        }
        System.out.printf("Rocket: %s is launching\n", name);
    }

    public static long planRocketLaunches(List<RacketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (RacketLaunch racketLaunch : launches) {
            try {
                Thread.sleep(racketLaunch.getLaunchTime());
            } catch (InterruptedException e) {
                log.warn("Thread sleep interrupted ", e);
            }
            executorService.execute(racketLaunch::launch);
        }

        executorService.shutdown();
        awaitingTermination(executorService);

        return System.currentTimeMillis() - startTime;
    }

    private static void awaitingTermination(ExecutorService executorService) {
        final int AWAITING_TIME = 3;

        try {
            if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("All launches terminated");
            } else {
                System.out.println(" Not all launches were terminated");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Thread interrupted ", e);
        }
    }
}
