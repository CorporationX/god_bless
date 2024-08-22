package faang.school.godbless.BJS2_24222;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@ToString
@AllArgsConstructor
public class RocketLaunch {
    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    private String rocketName;
    private LocalDateTimeForRocket startDateTime;

    public static long planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        long startTime = System.currentTimeMillis();

        System.out.println("Готовим ракеты: " + rocketLaunches);
        rocketLaunches.forEach(rocketLaunch -> scheduledExecutor.schedule(
                rocketLaunch::launch,
                rocketLaunch.startDateTime.toMills(),
                TimeUnit.MILLISECONDS
        ));

        LocalDateTimeForRocket latestDateTime = LocalDateTimeForRocket.findDateTimeLatestRocketLaunch(rocketLaunches);
        stop(latestDateTime);
        System.out.println("Все ракеты были запущены");

        return System.currentTimeMillis() - startTime;
    }

    private void launch() {
        System.out.println("Подготовка ракеты: " + rocketName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Запущена ракета: " + rocketName);
    }


    private static void stop(LocalDateTimeForRocket latestDateTime) {
        scheduledExecutor.shutdown();
        try {
            if (!scheduledExecutor.awaitTermination(latestDateTime.getWaitingTime(), TimeUnit.MILLISECONDS)) {
                scheduledExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutor.shutdownNow();
        }
    }
}
