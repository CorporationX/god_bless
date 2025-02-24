package space;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class SpaceProgram {
    public static void main(String[] args) {
        List<RocketLaunch> launches = Arrays.asList(
                new RocketLaunch("Falcon 9", 0),
                new RocketLaunch("Starship", 2000),
                new RocketLaunch("Falcon Heavy", 4000),
                new RocketLaunch("Electron", 6000)
        );

        LaunchPlanner planner = new LaunchPlanner();
        planner.planRocketLaunches(launches);
    }
}
