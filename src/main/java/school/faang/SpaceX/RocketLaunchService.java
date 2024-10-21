package school.faang.SpaceX;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLaunchService {

    public void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        ExecutorService service = Executors.newSingleThreadExecutor();

        launches.stream().sorted(Comparator.comparingLong(RocketLaunch::getLaunchTime))
                .forEach(launch -> {
                    long delay = launch.getLaunchTime() - System.currentTimeMillis();
                    service.execute(() -> {
                        try {
                            Thread.sleep(delay);
                            launch.launch();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
                });

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " milliseconds");
    }
}
