package faang.school.godbless.parallelismAndThread.spaceX;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketStarter {
    public void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        rocketLaunches = rocketLaunches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getTime))
                .toList();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : rocketLaunches) {
            executorService.submit(rocketLaunch);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
