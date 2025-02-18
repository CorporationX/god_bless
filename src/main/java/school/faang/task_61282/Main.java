package school.faang.task_61282;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(10)));

        RocketLaunchScheduler rocketLaunch = new RocketLaunchScheduler();
        long startTime = System.currentTimeMillis();
        rocketLaunch.planRocketLaunches(launches);
        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
