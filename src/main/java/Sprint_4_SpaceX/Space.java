package Sprint_4_SpaceX;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Space {

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunch = List.of(
                new RocketLaunch("Rocket 1", "10:00"),
                new RocketLaunch("Rocket 2", "11:00"),
                new RocketLaunch("Rocket 3", "12:00"),
                new RocketLaunch("Rocket 4", "13:00")
        );
        planRocketLaunches(rocketLaunch);
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunch) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < rocketLaunch.size(); i++) {

            int finalI = i;
            executor.execute(() -> rocketLaunch.get(finalI).launch());
            //executor.execute(rocketLaunch.get(i));
            //не дает написать просто executor.execute(() -> rocketLaunch.get(i).launch());
            //наверное, это избегаем замыкание, хотя, по сути, ничего не изменилось

        }
        executor.shutdown();
    }
}
