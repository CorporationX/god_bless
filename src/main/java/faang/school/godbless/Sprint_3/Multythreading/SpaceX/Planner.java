package faang.school.godbless.Sprint_3.Multythreading.SpaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Planner {
    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = new ArrayList<>();
        rocketLaunches.add(new RocketLaunch("R1", LocalDateTime.now().plusMinutes(23)));
        rocketLaunches.add(new RocketLaunch("R2", LocalDateTime.now().plusMinutes(85)));
        rocketLaunches.add(new RocketLaunch("R3", LocalDateTime.now().plusMinutes(9)));
        rocketLaunches.add(new RocketLaunch("R4", LocalDateTime.now().plusMinutes(3)));

        RocketLaunch.planRocketLaunches(rocketLaunches);
    }
}
