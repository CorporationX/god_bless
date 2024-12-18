package school.faang.task_48259;

import java.util.List;

public class Main {
    private static final int ROCKET_LAUNCH_DELAY = 2000;

    public static void main(String[] args) {
        RocketLaunchSystem rocketLaunchSystem = new RocketLaunchSystem();
        List<RocketLaunch> rocketLaunches = setUpRocketLaunches();

        rocketLaunchSystem.planRocketLaunches(rocketLaunches);
    }

    private static List<RocketLaunch> setUpRocketLaunches() {
        long firstRocketLaunchTime = System.currentTimeMillis() + ROCKET_LAUNCH_DELAY;
        RocketLaunch rocketLaunch1 = new RocketLaunch("Saturn-13", firstRocketLaunchTime);

        long secondRocketLaunchTime = System.currentTimeMillis() + ROCKET_LAUNCH_DELAY;
        RocketLaunch rocketLaunch2 = new RocketLaunch("Apollon-7", secondRocketLaunchTime);

        long thirdRocketLaunchTime = System.currentTimeMillis() + ROCKET_LAUNCH_DELAY;
        RocketLaunch rocketLaunch3 = new RocketLaunch("Moon-2", thirdRocketLaunchTime);

        return List.of(rocketLaunch1, rocketLaunch2, rocketLaunch3);
    }
}
