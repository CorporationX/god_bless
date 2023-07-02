package sprint4.spacex;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class SpaceX {
    private static final List<RocketLaunch> ROCKET_LAUNCHES = List.of(
            new RocketLaunch("Rocket 1", LocalDateTime.now().plusSeconds(2)),
            new RocketLaunch("Rocket 2", LocalDateTime.now().plusSeconds(4)),
            new RocketLaunch("Rocket 3", LocalDateTime.now().plusSeconds(6)),
            new RocketLaunch("Rocket 4", LocalDateTime.now().plusSeconds(8))
    );

    public static void main(String[] args) {
        LocalDateTime starTime = LocalDateTime.now();
        RocketLaunch.planRocketLaunches(ROCKET_LAUNCHES);

        long duration = Duration.between(starTime, LocalDateTime.now()).getSeconds();
        System.out.printf("Method worked %d seconds\n", duration);
    }
}
