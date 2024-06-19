package faang.school.godbless.spacex;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLauncher {
    private final int TIME_OUT = 100;

    public void planRocketLaunches(List<RocketLaunch> rocketLaunchList) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : rocketLaunchList) {
            executor.execute(rocketLaunch::launch);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
