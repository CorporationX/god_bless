package faang.school.godbless.spaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();

        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunchList) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long start = System.currentTimeMillis();

        rocketLaunchList.forEach((rocketLaunch -> {
            executorService.execute(rocketLaunch::launch);
        }));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(4, TimeUnit.SECONDS)) {
                long end = System.currentTimeMillis();
                System.out.println(end - start);
            } else {
                throw new RuntimeException("Time has expired");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
