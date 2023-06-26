package SpaceX;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PlannerRocketLaunches {
    public static void planRocketLaunches(List<RocketLaunch> launches){
        List<RocketLaunch> sortedLaunches = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getStartTime))
                .toList();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (RocketLaunch launch: sortedLaunches){
            executorService.execute(()-> System.out.println(launch.toString()));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
