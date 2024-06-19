package faang.school.godbless.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SpaceX {
    public static void main(String[] args) {
        RocketLauncher rocketLauncher = new RocketLauncher();
        List<RocketLaunch> launches = new ArrayList<>();

        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        long start = System.currentTimeMillis();

        rocketLauncher.planRocketLaunches(launches);

        long end = System.currentTimeMillis();
        System.out.println("Rocket Launching took " + (end - start) + " milliseconds");
    }
}
