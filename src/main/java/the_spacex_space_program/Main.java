package the_spacex_space_program;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 1", 1570000000000L),
                new RocketLaunch("Falcon 9", 1560000000000L),
                new RocketLaunch("Falcon 7", 1580000000000L),
                new RocketLaunch("Falcon 8", 1590000000000L),
                new RocketLaunch("Falcon 4", 1600000000000L)
        );

        RocketLaunch.planRocketLaunches(launches);
    }
}
