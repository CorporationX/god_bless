package faang.school.godbless;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainStartRockets {
    public static void main(String[] args) {
        List<RocketLaunch> startList = List.of(
                new RocketLaunch("FAANG School", LocalDateTime.now().plusSeconds(1)),
                new RocketLaunch("SpaceX", LocalDateTime.now().plusSeconds(3)),
                new RocketLaunch("Falcon777", LocalDateTime.now().plusSeconds(5))
        );

        long beforeStart = System.currentTimeMillis();
        planRocketLaunches(startList);
        long afterStart = System.currentTimeMillis();

        System.out.println("All rockets starts in: " + (afterStart - beforeStart) + " milliseconds");
    }

    public static void planRocketLaunches(List<RocketLaunch> startList){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for(RocketLaunch launch: startList){
            executor.submit(launch);
        }
        executor.shutdown();

        try{
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
