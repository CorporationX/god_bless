package Multithreading.bc2409;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class RocketLaunch implements Runnable {
    private String name;
    private LocalDateTime time;

    public void launch() {
        System.out.println("Launching " + getName() + " at " + getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " has been launched!");
    }

    public static void planRocketLaunches(List<RocketLaunch> rockets) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch launch : rockets) {
            executor.execute(launch);
        }
        executor.shutdown();

        boolean isFinished = executor.awaitTermination(20, TimeUnit.SECONDS);
        if (isFinished) {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Method planRocketLaunches execution time: " + executionTime + " milliseconds.");
        }
    }

    @Override
    public void run() {
        if (getTime().isAfter(LocalDateTime.now())) {
            Duration duration = Duration.between(LocalDateTime.now(), getTime());
            try {
                Thread.sleep(duration.toMillis());
                launch();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
