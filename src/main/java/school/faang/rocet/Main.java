package school.faang.rocet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 1", 1000),
                new RocketLaunch("Falcon 9", 4000),
                new RocketLaunch("Starship", 3000)
        );

        RocketLaunch rocketLauncher = new RocketLaunch();
        rocketLauncher.planRocketLaunches(launches);
    }
}
