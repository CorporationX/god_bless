package faang.school.godbless.bjs2_5555;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        planRocketLaunches(getLaunches());
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Start all launch time: " + currentTime);

        for (RocketLaunch launch : launches) {
            executor.execute(launch::launch);
        }
        executor.shutdown();

        try {
            while (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nEnd all launch time: " + now);
        System.out.println("Elapsed time: " + (now.getSecond() - currentTime.getSecond()));
    }

    private static List<RocketLaunch> getLaunches() {
        List<RocketLaunch> launches = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        launches.add(new RocketLaunch("Falcon 9", now.plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", now.plusSeconds(10)));
        launches.add(new RocketLaunch("Crew Dragon", now.plusSeconds(20)));
        return launches;
    }
}
