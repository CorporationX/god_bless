package sprint4.spacex;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class RocketLaunch {
    private static final ExecutorService SERVICE = Executors.newSingleThreadExecutor();
    private final String name;
    private final LocalDateTime startTime;

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        for (RocketLaunch rocket : rocketLaunches) {
            LocalDateTime currentTime = LocalDateTime.now();
            long duration = Duration.between(currentTime, rocket.startTime).toMillis();

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
            SERVICE.execute(rocket::launch);
        }
        SERVICE.shutdown();

        try {
            SERVICE.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
    }

    public void launch() {
        System.out.printf("Rocket %s launches\n", name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        System.out.printf("Rocket %s has launched\n", name);
    }
}
