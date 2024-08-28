package faang.school.godbless.space_x;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String titleStart;
    private long timeStart;

    public void launch() {

        System.out.println("Запускаем ракету %s".formatted(titleStart));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поехали!");
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunchList) {
        ScheduledExecutorService poolThreads = Executors.newSingleThreadScheduledExecutor();

        rocketLaunchList.sort(Comparator.comparingLong(RocketLaunch::getTimeStart));
        long currentTime = System.currentTimeMillis();

        for (RocketLaunch launch : rocketLaunchList) {
            long delay = launch.getTimeStart() - currentTime;
            if (delay > 0) {
                poolThreads.schedule(launch::launch, delay, TimeUnit.MILLISECONDS);
            }
        }
        poolThreads.shutdown();
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Apollo 11", System.currentTimeMillis() + 3000));
        launches.add(new RocketLaunch("Falcon Heavy", System.currentTimeMillis() + 10000));
        launches.add(new RocketLaunch("Soyuz MS-10", System.currentTimeMillis() + 5000));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to plan rocket launches: " + (endTime - startTime) + " ms");
    }
}
