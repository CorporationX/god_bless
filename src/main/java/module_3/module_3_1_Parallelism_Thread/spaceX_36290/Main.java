package module_3.module_3_1_Parallelism_Thread.spaceX_36290;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 1", 2000),
                new RocketLaunch("Falcon 9", 5000),
                new RocketLaunch("Falcon Heavy", 10000)
        );

        RocketLaunch rocketLaunch = new RocketLaunch();
        rocketLaunch.planRocketLaunches(launches);
    }
}
