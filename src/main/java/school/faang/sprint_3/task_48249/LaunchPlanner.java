package school.faang.sprint_3.task_48249;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LaunchPlanner {
    private static final int AWAIT_TIME = 1;

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        launches.stream()
                .sorted(Comparator.comparingInt(RocketLaunch::getLaunchTime))
                .forEach(rocketLaunch -> executorService.submit(rocketLaunch::launch));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Planning interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
