package school.faang.bjs2_72888;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RocketLaunch morningLaunch = new RocketLaunch(
            "AA1", 
            Instant.now().plus(7, ChronoUnit.SECONDS).toEpochMilli()
        );
        RocketLaunch lunchLaunch = new RocketLaunch(
            "AA2", 
            Instant.now().plus(5, ChronoUnit.SECONDS).toEpochMilli()
        );
        RocketLaunch eveningLaunch = new RocketLaunch(
            "AA3", 
            Instant.now().plus(20, ChronoUnit.SECONDS).toEpochMilli()
        );
        
        morningLaunch.planRocketLaunches(List.of(morningLaunch, lunchLaunch, eveningLaunch));
    }
}
