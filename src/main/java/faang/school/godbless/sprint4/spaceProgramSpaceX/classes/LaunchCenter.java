package faang.school.godbless.sprint4.spaceProgramSpaceX.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LaunchCenter {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(12)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        RocketLaunch.planRocketLaunches(launches);
    }
}