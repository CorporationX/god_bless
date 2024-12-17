package school.faang.task_48259;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RocketLaunchSystem rocketLaunchSystem = new RocketLaunchSystem();
        List<RocketLaunch> rocketLaunches = setUpRocketLaunches();

        rocketLaunchSystem.planRocketLaunches(rocketLaunches);
    }

    private static List<RocketLaunch> setUpRocketLaunches() {
        List<RocketLaunch> rocketLaunches = new ArrayList<>();

        long firstRocketLaunchTime = System.currentTimeMillis() + 1000;
        RocketLaunch rocketLaunch1 = new RocketLaunch("Saturn-13", firstRocketLaunchTime);

        long secondRocketLaunchTime = System.currentTimeMillis() + 2000;
        RocketLaunch rocketLaunch2 = new RocketLaunch("Apollon-7", secondRocketLaunchTime);

        long thirdRocketLaunchTime = System.currentTimeMillis() + 2000;
        RocketLaunch rocketLaunch3 = new RocketLaunch("Moon-2", thirdRocketLaunchTime);

        rocketLaunches.add(rocketLaunch1);
        rocketLaunches.add(rocketLaunch2);
        rocketLaunches.add(rocketLaunch3);

        return rocketLaunches;
    }
}
