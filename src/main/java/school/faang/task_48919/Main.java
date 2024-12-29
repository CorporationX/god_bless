package school.faang.task_48919;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LaunchingSystem launchingSystem = new LaunchingSystem();

        RocketLaunch rocket1 = new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2));
        RocketLaunch rocket2 = new RocketLaunch("Starship", LocalDateTime.now()
                .plusSeconds(5));
        RocketLaunch rocket3 = new RocketLaunch("Falcon Heavy", LocalDateTime.now()
                .plusSeconds(3));


        long startTime = System.currentTimeMillis();
        launchingSystem.planRocketLaunches(List.of(rocket1, rocket2, rocket3));
        long endTime = System.currentTimeMillis();

        System.out.printf("Запуски завершены за %d миллисекунд.%n", (endTime - startTime));
    }
}
