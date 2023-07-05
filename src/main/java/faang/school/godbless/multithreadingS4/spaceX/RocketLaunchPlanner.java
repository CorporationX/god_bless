package faang.school.godbless.multithreadingS4.spaceX;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLaunchPlanner {
    public static void planRocketLaunches(List<RocketLaunch> rocketLaunchList) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        rocketLaunchList.stream()
                .sorted(Comparator.comparing(RocketLaunch::getStartTime))
                .forEach(rocketLaunch -> executorService.execute(rocketLaunch::launch));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("\tThreads execution timeout expired");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
