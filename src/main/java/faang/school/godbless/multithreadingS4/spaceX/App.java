package faang.school.godbless.multithreadingS4.spaceX;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)),
                new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5))
        );

        long startTime = System.currentTimeMillis();
        RocketLaunchPlanner.planRocketLaunches(launches);
        long stopTime = System.currentTimeMillis();
        System.out.printf("%nTime spent: %d ms", stopTime - startTime);
    }
}
