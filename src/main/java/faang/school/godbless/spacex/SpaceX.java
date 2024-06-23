package faang.school.godbless.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SpaceX {
    public static void main(String[] args) {
        RocketLauncher rocketLauncher = new RocketLauncher();
        List<RocketLaunch> rocketLaunches = getRocketLauncher();

        long start = System.currentTimeMillis();

        rocketLauncher.planRocketLaunches(rocketLaunches);

        long end = System.currentTimeMillis();
        System.out.println("Rocket Launching took " + (end - start) + " milliseconds");
    }

    private static List<RocketLaunch> getRocketLauncher(){
        List<RocketLaunch> rocketLaunches = new ArrayList<>();

        rocketLaunches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        rocketLaunches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        rocketLaunches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        return rocketLaunches;
    }
}
