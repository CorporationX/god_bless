package school.faang.thespaceprogramspacex;

import java.util.Arrays;
import java.util.List;

public class SpaceXLauncher {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = Arrays.asList(
                new RocketLaunch("Falcon 1", System.currentTimeMillis() + 3000), // 3 seconds later
                new RocketLaunch("Falcon 9", System.currentTimeMillis() + 5000), // 5 seconds later
                new RocketLaunch("Starship", System.currentTimeMillis() + 7000)  // 7 seconds later
        );

        RocketScheduler.planRocketLaunches(rocketLaunches);
    }
}