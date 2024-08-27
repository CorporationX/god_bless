package faang.school.godbless.SpaceX;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Cosmodrome {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();

        LocalDateTime currentDateTime = LocalDateTime.now();
        launches.add(new RocketLaunch("Rocket Soyuz", currentDateTime.plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon 9", currentDateTime.plusSeconds(15)));
        launches.add(new RocketLaunch("Falcon 7", currentDateTime.plusSeconds(10)));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to execute planRocketLaunches: " + (endTime - startTime) + " ms");
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            launches
                    .stream()
                    .sorted(Comparator.comparing(RocketLaunch::getLaunchDateTime))
                    .forEach(launch -> executor.submit(() -> {
                        LocalDateTime launchDateTime = launch.getLaunchDateTime();
                        long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), launchDateTime);

                        if (delay > 0) {
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                System.err.println("Launch of " + launchDateTime + " was interrupted");
                            }
                        }
                        launch.launch();
                    }));

            executor.shutdown();
            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                executor.shutdownNow();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
