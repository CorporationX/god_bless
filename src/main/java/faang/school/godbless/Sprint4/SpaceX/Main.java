package faang.school.godbless.Sprint4.SpaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.Sprint4.SpaceX.RocketLaunch.planRocketLaunches;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(6000)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(1000)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(10000)));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));
    }
}
