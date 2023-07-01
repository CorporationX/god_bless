package Multithreading.bc2409;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

    }
}
