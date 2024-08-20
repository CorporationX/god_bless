package spacex;

import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var launches = List.of(
                new RocketLaunch("Starlink Group 10-5", LocalDateTime.now().plusSeconds(2)),
                new RocketLaunch("Transporter 11", LocalDateTime.now().plusSeconds(3)),
                new RocketLaunch("WorldView Legion 3 & 4", LocalDateTime.now().plusSeconds(5)),
                new RocketLaunch("CRS NG-21", LocalDateTime.now().plusSeconds(4)),
                new RocketLaunch("NROL-186", LocalDateTime.now().plusSeconds(1)),
                new RocketLaunch("SpaceX Crew-8", LocalDateTime.now().plusSeconds(10)));
        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(@NonNull List<RocketLaunch> launches) {
        validateLaunches(launches);
        try (ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor()) {
            var start = System.currentTimeMillis();
            for (RocketLaunch launch : launches) {
                Duration duration = Duration.between(launch.getLaunchTime(), LocalDateTime.now());
                executor.schedule(launch::launch, duration.getNano(), TimeUnit.NANOSECONDS);
            }
            executor.shutdown();
            try {
                if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    System.out.printf("All missions launch successfully in %d mS%n",
                            System.currentTimeMillis() - start);
                } else {
                    System.out.println("Planning takes too long! SpaceX is bankrupt!");
                }
            } catch (InterruptedException e) {
                System.out.println("Planner failed!");
                e.printStackTrace();
            }
        }
    }

    private static void validateLaunches(@NonNull List<RocketLaunch> launches) {
        if (launches.isEmpty()) {
            throw new IllegalArgumentException("No launches to schedule!");
        }
    }
}
