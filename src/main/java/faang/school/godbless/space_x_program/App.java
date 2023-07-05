package faang.school.godbless.space_x_program;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("Falcon", LocalDateTime.now().plusSeconds(1)),
                new RocketLaunch("Atlas V", LocalDateTime.now().plusSeconds(4)),
                new RocketLaunch("Delta IV", LocalDateTime.now().plusSeconds(10))
        );

        long startTime = System.currentTimeMillis();
        RocketLaunch.planRocketLaunches(rocketLaunches);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }
}
