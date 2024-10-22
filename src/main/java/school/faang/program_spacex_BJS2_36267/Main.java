package school.faang.program_spacex_BJS2_36267;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RacketLaunch> launches = new ArrayList<>(Arrays.asList(
                new RacketLaunch("Apollo 11", 2500),
                new RacketLaunch("Falcon Heavy", 3800),
                new RacketLaunch("Vostok 1", 2200),
                new RacketLaunch("Mars Odyssey", 1400)));

        long executionTime = RacketLaunch.planRocketLaunches(launches);

        System.out.println("Total execution time: " + executionTime + " ms");
    }
}
