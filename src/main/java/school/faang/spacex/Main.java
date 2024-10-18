package school.faang.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = new ArrayList<>();
        rocketLaunches.add(new RocketLaunch("Starship", LocalDateTime.now().plusSeconds(10)));
        rocketLaunches.add(new RocketLaunch("Falcon", LocalDateTime.now().plusSeconds(20)));
        rocketLaunches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(15)));

        RockerLaunchPlanner planner = new RockerLaunchPlanner();
        long startTime = System.currentTimeMillis();
        planner.planRocketLaunches(rocketLaunches);
        long endTime = System.currentTimeMillis();
        System.out.println("Программа выполнилась за " + (endTime - startTime) + "ms");
    }
}
