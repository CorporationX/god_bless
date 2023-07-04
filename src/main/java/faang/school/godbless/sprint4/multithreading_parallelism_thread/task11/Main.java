package faang.school.godbless.sprint4.multithreading_parallelism_thread.task11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.sprint4.multithreading_parallelism_thread.task11.RocketLaunch.planRocketLaunches;

public class Main {

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(10)));

        planRocketLaunches(launches);
    }


}
