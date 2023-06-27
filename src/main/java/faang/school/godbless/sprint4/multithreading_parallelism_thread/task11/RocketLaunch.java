package faang.school.godbless.sprint4.multithreading_parallelism_thread.task11;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class RocketLaunch implements Runnable {

    private String name;

    private LocalDateTime startDate;

    @SneakyThrows
    public void launch() {
        System.out.println("Ракета " + name + " запущена в " + startDate);
        Thread.sleep(1000);
    }

    @Override
    @SneakyThrows
    public void run() {
        if (startDate.isAfter(LocalDateTime.now())) {
            Duration duration = Duration.between(LocalDateTime.now(), startDate);
            Thread.sleep(duration.toMillis());
        }
        long startTime = System.currentTimeMillis();
        launch();
        long endTime = System.currentTimeMillis();
        System.out.println("Затрачено "+ (endTime - startTime) / 1000 + " секунд");
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : rocketLaunches) {
            executor.submit(rocketLaunch);
        }
        executor.shutdown();
    }
}
