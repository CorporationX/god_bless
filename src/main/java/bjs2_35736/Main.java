package bjs2_35736;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("FAANG", 1000),
                new RocketLaunch("SpaceX", 2000),
                new RocketLaunch("NASA", 1500)
        );

        long startTime = System.currentTimeMillis();

        RocketLaunch.planRocketLaunches(launches);
        RocketLaunch.shutdownExecutionService();

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
