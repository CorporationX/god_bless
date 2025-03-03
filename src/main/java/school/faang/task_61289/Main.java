package school.faang.task_61289;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(10)));

        long startTime = System.currentTimeMillis();
        LaunchManager launchManager = new LaunchManager();
        launchManager.planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
}
