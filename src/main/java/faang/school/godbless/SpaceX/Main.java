package faang.school.godbless.SpaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = getLaunches();
        RocketLaunchService service = new RocketLaunchService();

        long start = System.currentTimeMillis();
        service.planRocketLaunches(launches);
        long end = System.currentTimeMillis();

        System.out.println("Время выполнения - " + (end - start) + "мс");
    }

    private static List<RocketLaunch> getLaunches() {
        RocketLaunch launch1 = new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(3));
        RocketLaunch launch2 = new RocketLaunch("Atlas V", LocalDateTime.now().plusMinutes(1));
        RocketLaunch launch3 = new RocketLaunch("Delta IV", LocalDateTime.now().plusMinutes(4));
        RocketLaunch launch4 = new RocketLaunch("SpaceX Starship", LocalDateTime.now().plusMinutes(5));
        RocketLaunch launch5 = new RocketLaunch("Ariane 5", LocalDateTime.now().plusMinutes(2));
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(launch1);
        launches.add(launch2);
        launches.add(launch3);
        launches.add(launch4);
        launches.add(launch5);
        return launches;
    }
}
