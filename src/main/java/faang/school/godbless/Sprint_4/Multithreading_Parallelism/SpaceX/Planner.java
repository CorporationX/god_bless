package faang.school.godbless.Sprint_4.Multithreading_Parallelism.SpaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Planner {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = new ArrayList<>();
        rocketLaunches.add(new RocketLaunch("R1", LocalDateTime.now().plusSeconds(10)));
        rocketLaunches.add(new RocketLaunch("R2", LocalDateTime.now().plusSeconds(8)));
        rocketLaunches.add(new RocketLaunch("R3", LocalDateTime.now().plusSeconds(5)));
        rocketLaunches.add(new RocketLaunch("R4", LocalDateTime.now().plusSeconds(3)));

        RocketLaunch.planRocketLaunches(rocketLaunches);
    }
}
