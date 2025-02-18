package spacex;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Rocket A", 2000),
                new RocketLaunch("Rocket B", 1000),
                new RocketLaunch("Rocket C", 1500),
                new RocketLaunch("Rocket D", 2500),
                new RocketLaunch("Rocket E", 500),
                new RocketLaunch("Rocket F", 4500)
        );

        RocketLaunch.planRocketLaunches(launches);
    }
}