package school.faang.SpaceX;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Союз-1", System.currentTimeMillis() + 2000),
                new RocketLaunch("Falcon 9", System.currentTimeMillis() + 4000),
                new RocketLaunch("Atlas V", System.currentTimeMillis() + 6000)
        );

        RocketLauncher launcher = new RocketLauncher();
        long startTime = System.currentTimeMillis();
        launcher.planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();

        System.out.printf("Время выполнения: %s мс%n", (endTime - startTime));
    }
}