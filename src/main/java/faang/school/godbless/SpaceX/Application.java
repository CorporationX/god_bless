package faang.school.godbless.SpaceX;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Launch 1", LocalDateTime.now().plusSeconds(1)));
        launches.add(new RocketLaunch("Launch 2", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Launch 3", LocalDateTime.now().plusSeconds(3)));

        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) throws InterruptedException {
        Long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        rocketLaunches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getLaunchTime))
                .toList()
                .forEach(rocketLaunch -> {
                    executor.execute(() -> {
                        try {
                            rocketLaunch.launch();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    });
                });

        executor.shutdown();
        if (executor.awaitTermination(4000, TimeUnit.MILLISECONDS)) {
            System.out.println("Time spent: " + ((System.currentTimeMillis() - start) / 1000) + " seconds");
        }
    }
}
