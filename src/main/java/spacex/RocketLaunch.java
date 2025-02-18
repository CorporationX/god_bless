package spacex;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Getter
public class RocketLaunch {
    private static final Logger logger = Logger.getLogger(RocketLaunch.class.getName());
    private final String name;
    private final long launchTime;
    public static long startTime;
    public static long endTime;

    public RocketLaunch(String name, long launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }

    public void launch() {
        try {
            logger.info(String.format("%s launch initiated...", name));
            Thread.sleep(1000);
            logger.info(String.format("Rocket %s launched successfully!", name));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe("Launch interrupted! There people on the launch site!");
        }
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        startTime = System.currentTimeMillis();

        launches.stream()
                .sorted(Comparator.comparingLong(RocketLaunch::getLaunchTime))
                .forEach(launch -> executorService.submit(launch::launch));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                logger.warning("Rocket launches didn't finish in time!");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            logger.severe("Execution was interrupted!");
            executorService.shutdownNow();
        }

        endTime = System.currentTimeMillis();
        logger.info("Total time to plan and execute rocket launches: " + (endTime - startTime) + " ms");
    }
}