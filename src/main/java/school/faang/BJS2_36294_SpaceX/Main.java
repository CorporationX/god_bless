package school.faang.BJS2_36294_SpaceX;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cosmodrome cosmodrome = new Cosmodrome();

        List<RocketLaunch> launches = Arrays.asList(
                new RocketLaunch("Apollo 11", 2000),
                new RocketLaunch("Falcon 9", 3000),
                new RocketLaunch("Soyuz MS-10", 2500)
        );

        cosmodrome.planRocketLaunches(launches);
    }
}
