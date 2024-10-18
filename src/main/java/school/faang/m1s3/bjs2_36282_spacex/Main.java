package school.faang.m1s3.bjs2_36282_spacex;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>(List.of(
                new RocketLaunch("Enterprise", LocalTime.now().plusSeconds(10)),
                new RocketLaunch("Galactica", LocalTime.now().plusSeconds(15)),
                new RocketLaunch("Death Star", LocalTime.now().plusSeconds(30))
        ));
        LaunchPlanner launchPlanner = new LaunchPlanner(launches);

        launchPlanner.planRocketLaunches();
    }
}
