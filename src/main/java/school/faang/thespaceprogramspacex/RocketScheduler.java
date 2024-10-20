package school.faang.thespaceprogramspacex;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketScheduler {

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        launches.sort((rl1, rl2) -> Long.compare(rl1.getLaunchTime(), rl2.getLaunchTime()));
    }
}
