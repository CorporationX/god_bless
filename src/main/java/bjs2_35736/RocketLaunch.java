package bjs2_35736;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLaunch {
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private String name;
    @Getter
    private long launchTime;

    public RocketLaunch(String name, long launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        for (RocketLaunch launch : launches) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(launch.getLaunchTime());
                    launch.launch();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static void shutdownExecutionService() throws InterruptedException {
        executorService.shutdown();

        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Time limit has been reached. Forcing shutdown");
            executorService.shutdownNow();
        }
    }

    private void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.printf("Rocket %s was launched!\n", name);
    }
}
