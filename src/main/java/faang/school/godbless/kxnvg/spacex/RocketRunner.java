package faang.school.godbless.kxnvg.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RocketRunner {

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

        long startTime = System.currentTimeMillis();

        RocketLaunch.planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();
        System.out.println("Общее время выполнения программы равно " + (endTime - startTime) + "мс");
    }
}
