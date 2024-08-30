package faang.school.godbless.spaceX;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void waitAndLaunch(RocketLaunch rocketLaunch) throws InterruptedException {
        if (rocketLaunch.getStartTime().isAfter(LocalDateTime.now())) {
            long waitingTime = ChronoUnit.MILLIS.between(LocalDateTime.now(), rocketLaunch.getStartTime());
            Thread.sleep(waitingTime);
            rocketLaunch.launch();
        }
    }

    public static void planRocketLaunch(List<RocketLaunch> rocketLaunches) {
        long startTime = System.currentTimeMillis();

        rocketLaunches.sort(Comparator.comparing(RocketLaunch::getStartTime));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : rocketLaunches) {
            executorService.submit(() -> {
                try {
                    waitAndLaunch(rocketLaunch);
                } catch (InterruptedException e) {
                    System.out.println("Rocket launch was interrupted");
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Rockets` launches took " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();

        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(20)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(60)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(40)));

        planRocketLaunch(launches);
    }
}
