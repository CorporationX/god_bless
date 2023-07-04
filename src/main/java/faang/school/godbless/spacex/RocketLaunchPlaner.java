package faang.school.godbless.spacex;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.spacex.RocketLaunch.planRocketLaunches;


public class RocketLaunchPlaner {

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

        long startTime = System.currentTimeMillis();

        planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}
