package school.faang.godbless.bjs2_36289;

import java.util.List;

public class SpaceProgram {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Rocket1", 1000),
                new RocketLaunch("Rocket2", 3000),
                new RocketLaunch("Rocket3", 2000),
                new RocketLaunch("Rocket4", 1500),
                new RocketLaunch("Rocket5", 4000)
        );
        Launcher.planRocketLaunches(launches);
    }
}
