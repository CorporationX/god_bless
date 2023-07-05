package faang.school.godbless.sprint3.spaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch implements Runnable {
    private String name;
    private long launchTime;

    @Override
    public void run() {
        launch();
    }

    public void launch() {
        System.out.println("Launching " + name + " at " + launchTime);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " has launched!");

    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for (RocketLaunch rocketLaunch : rocketLaunches) {
            long delay = rocketLaunch.launchTime - System.currentTimeMillis();
            executorService.schedule(rocketLaunch, delay, TimeUnit.MILLISECONDS);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
