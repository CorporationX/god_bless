package faang.school.godbless.spacex;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = getRocketLaunches();
        Long startTime = System.currentTimeMillis();
        RocketLaunch.planRocketLaunches(rocketLaunches);
        Long endTime = System.currentTimeMillis();
        Long totalTime = (endTime - startTime) / 1000;
        System.out.println(String.format("Total \"planRocketLaunches\" method run time: %ds", totalTime));
    }

    private static List<RocketLaunch> getRocketLaunches() {
        return List.of(new RocketLaunch("Rocket launch 1", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("Rocket launch 2", LocalDateTime.now().plusSeconds(20)),
                new RocketLaunch("Rocket launch 3", LocalDateTime.now().plusSeconds(30)));
    }
}
