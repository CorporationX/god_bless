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
        scheduleLaunches(launches);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to execute planRocketLaunches: " + (endTime - startTime) + " ms");
    }

    public static void scheduleLaunches(List<RocketLaunch> launches) {
        List<RocketLaunch> sortedLaunches = sortLaunchesByDate(launches);
        executeLaunches(sortedLaunches);
    }

    private static List<RocketLaunch> sortLaunchesByDate(List<RocketLaunch> launches) {
        return launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getLaunchDateTime))
                .toList();
    }

    private static void executeLaunches(List<RocketLaunch> launches) {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            launches.forEach(launch -> executor.submit(() -> handleLaunch(launch)));
            shutdownExecutor(executor);
        } catch (Exception e) {
            handleError(e);
        }
    }

    private static void handleLaunch(RocketLaunch launch) {
        LocalDateTime launchDateTime = launch.getLaunchDateTime();
        long delay = calculateDelay(launchDateTime);

        if (delay > 0) {
            sleepForDelay(delay, launchDateTime);
        }
        launch.launch();
    }

    private static long calculateDelay(LocalDateTime launchDateTime) {
        return ChronoUnit.MILLIS.between(LocalDateTime.now(), launchDateTime);
    }

    private static void sleepForDelay(long delay, LocalDateTime launchDateTime) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Launch of " + launchDateTime + " was interrupted");
        }
    }

    private static void shutdownExecutor(ExecutorService executor) throws InterruptedException {
        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    private static void handleError(Exception e) {
        System.err.println(e.getMessage());
    }
}
