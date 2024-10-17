package school.faang.spacex.main;

import school.faang.spacex.maincode.RocketLaunch;
import school.faang.spacex.maincode.RocketLauncherService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RocketLauncherService launcherService = new RocketLauncherService();

        RocketLaunch rocketLaunch1 = new RocketLaunch("rocketLaunch1", 1000);
        RocketLaunch rocketLaunch2 = new RocketLaunch("rocketLaunch2", 1500);
        RocketLaunch rocketLaunch3 = new RocketLaunch("rocketLaunch3", 1000);
        RocketLaunch rocketLaunch4 = new RocketLaunch("rocketLaunch4", 1500);
        RocketLaunch rocketLaunch5 = new RocketLaunch("rocketLaunch5", 2000);

        List<RocketLaunch> launches = Arrays.asList(rocketLaunch1, rocketLaunch2, rocketLaunch3,
                rocketLaunch4, rocketLaunch5);

        long startTime = System.currentTimeMillis();

        launcherService.planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();

        System.out.println("Программа работала " + (endTime - startTime) + "ms");
    }
}
