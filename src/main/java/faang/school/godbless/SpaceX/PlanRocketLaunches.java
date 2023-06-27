package faang.school.godbless.SpaceX;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlanRocketLaunches {
    private List<RocketLaunch> rocketLaunches = List.of(new RocketLaunch("Falcon", LocalDateTime.now().plusSeconds(30))
            ,new RocketLaunch("Starship", LocalDateTime.now().plusSeconds(3)));

    public static void main(String[] args) {
        PlanRocketLaunches planRocketLaunches = new PlanRocketLaunches();
        planRocketLaunches.planRocketLaunches();
    }

    public void planRocketLaunches(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < rocketLaunches.size(); i++) {
            service.execute(rocketLaunches.get(i));
        }
        service.shutdown();
    }
}
