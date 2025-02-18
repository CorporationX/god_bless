package bjs2_56245;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime now = OffsetDateTime.now();

        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Ракета 1", now.plusSeconds(1)));
        launches.add(new RocketLaunch("Ракета 2", now.plusSeconds(7)));
        launches.add(new RocketLaunch("Ракета 3", now.plusSeconds(3)));
        launches.add(new RocketLaunch("Ракета 4", now.plusSeconds(4)));
        launches.add(new RocketLaunch("Ракета 5", now.plusNanos(3500L * 1000 * 1000)));

        long startTime = System.currentTimeMillis();

        LaunchScheduler.planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы planRocketLaunches: %d мс%n", endTime - startTime);
    }
}
