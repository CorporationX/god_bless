package school.faang.thespaceprogramspacex;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketScheduler {

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        launches.sort((rl1, rl2) -> Long.compare(rl1.getLaunchTime(), rl2.getLaunchTime()));
        ExecutorService executor = Executors.newSingleThreadExecutor();

        long startTime = System.currentTimeMillis();

        launches.forEach(launch -> executor.submit(() -> {
            long delay = launch.getLaunchTime() - System.currentTimeMillis();
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Launch scheduling interrupted.");
                }
            }
            launch.launch();
        }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total scheduling process took: " + (endTime - startTime) + "ms");

    }
}