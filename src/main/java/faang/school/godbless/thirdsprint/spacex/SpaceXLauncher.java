package faang.school.godbless.thirdsprint.spacex;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class SpaceXLauncher {
    public static void main(String[] args) {
        List<RocketLaunch> launches = Arrays.asList(
                new RocketLaunch("Falcon 1", LocalDateTime.now().plusMinutes(1)),
                new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(3))
        );

        SpaceXLaunchScheduler scheduler = new SpaceXLaunchScheduler();
        scheduler.planRocketLaunches(launches);
        System.out.println("Total time taken to plan launches: " + scheduler.getExecutionTime() + " ms");
    }
}
