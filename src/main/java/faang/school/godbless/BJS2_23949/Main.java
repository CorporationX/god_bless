package faang.school.godbless.BJS2_23949;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final List<RocketLaunch> launches = new ArrayList<>();

    public static void main(String[] args) {
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        planRocketLaunches();
    }

    private static void planRocketLaunches() {
        if (launches.isEmpty()) {
            throw new IllegalArgumentException("No launches found");
        }

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        long startTime = System.currentTimeMillis();
        for (RocketLaunch launch : launches) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), launch.getLaunchTime());
            executorService.schedule(launch::launch, delay, TimeUnit.MILLISECONDS);
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All launches completed in " + (System.currentTimeMillis() - startTime) + " ms");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
