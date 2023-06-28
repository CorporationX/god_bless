package SpaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));
        launches.add(new RocketLaunch("Apollo 11", LocalDateTime.now().plusMinutes(1)));

        long startTime = System.currentTimeMillis();

        PlannerRocketLaunches.planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Total execution time is " + totalTime + "millis");
    }
}
