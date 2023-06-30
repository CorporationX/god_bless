package faang.school.godbless.spaceX;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(15)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(25)));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        LocalDateTime now = LocalDateTime.now();
        for (RocketLaunch launch : launches) {
            long delay = ChronoUnit.MILLIS.between(now, launch.getLaunchTime());
            executorService.schedule(() -> launch.launch(), delay, TimeUnit.MILLISECONDS);
        }

        executorService.shutdown();
        try {
            boolean terminated = executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
            if (!terminated) {
                System.err.println("Failed to wait for all tasks to be completed");
            }
        } catch (InterruptedException e) {
            System.err.println("Exception received - InterruptedException: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
