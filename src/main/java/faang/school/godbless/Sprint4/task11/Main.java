package faang.school.godbless.Sprint4.task11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(7)));

        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : launches) {
            executor.submit(rocketLaunch::launch);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime);
    }
}
