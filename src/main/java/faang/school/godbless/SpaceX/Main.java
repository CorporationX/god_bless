package faang.school.godbless.SpaceX;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(554)),
                new RocketLaunch("Starship", LocalDateTime.now().plusMonths(10)),
                new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(3)),
                new RocketLaunch("Kraken", LocalDateTime.now().minusDays(10))
        );
        RocketLaunch.planRocketLaunches(rocketLaunches);
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Done, " + Duration.between(startTime,endTime).getSeconds());
    }
}
