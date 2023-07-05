package faang.school.godbless.sprint3.spaceX;


import java.util.List;

import static faang.school.godbless.sprint3.spaceX.RocketLaunch.planRocketLaunches;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("Mars Rover", System.currentTimeMillis() + 3000),
                new RocketLaunch("SpaceX Falcon", System.currentTimeMillis() + 5000),
                new RocketLaunch("Apollo 11", System.currentTimeMillis() + 8000)
        );


        long startTime = System.currentTimeMillis();
        planRocketLaunches(rocketLaunches);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}
