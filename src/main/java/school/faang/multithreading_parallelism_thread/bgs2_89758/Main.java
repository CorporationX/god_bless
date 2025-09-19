package school.faang.multithreading_parallelism_thread.bgs2_89758;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>(List.of(
                /*new RocketLaunch("Мираж", 4233),
                new RocketLaunch("Сияние", 3324),
                new RocketLaunch("Воздух", 1223),
                new RocketLaunch("Казань", 1800),
                new RocketLaunch("Москва", 4556),*/

                new RocketLaunch("Питер", 9554),
                new RocketLaunch("Воронеж", 4556),
                new RocketLaunch("Питер22", 324)
        ));
        RocketLaunch.planRocketLaunches(launches);
    }
}
