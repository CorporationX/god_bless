package faang.school.godbless.kxnvg.spacex;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class RocketLaunch implements Runnable {

    private String name;
    private LocalDateTime startTime;

    @Override
    public void run() {
        launch();
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ракета " + name + " запущена в " + startTime);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            service.execute(launch);
        }
        service.shutdown();
        try {
            service.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
