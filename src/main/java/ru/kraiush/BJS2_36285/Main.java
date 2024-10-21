package ru.kraiush.BJS2_36285;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>(Arrays.asList(
                new RocketLaunch("Bison", LocalDateTime.now().plusSeconds(20)),
                new RocketLaunch("Falcon", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("Starship", LocalDateTime.now().plusSeconds(40)),
                new RocketLaunch("Horizon", LocalDateTime.now().plusSeconds(30))
        ));

        RocketLaunch.planRocketLaunches(launches);
    }
}
