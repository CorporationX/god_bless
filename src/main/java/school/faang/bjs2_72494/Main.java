package school.faang.bjs2_72494;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RocketLaunchService service = new RocketLaunchService();
        LocalDateTime now = LocalDateTime.now();

        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 9", now.plusSeconds(2)),
                new RocketLaunch("Starship", now.plusSeconds(4)),
                new RocketLaunch("Dragon", now.plusSeconds(6))
        );

        service.planRocketLaunches(launches);
    }
}
