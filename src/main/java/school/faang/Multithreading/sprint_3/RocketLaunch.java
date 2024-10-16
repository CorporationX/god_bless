package school.faang.Multithreading.sprint_3;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class RocketLaunch {
    private String name;
    private long launchTime;

    public RocketLaunch() {
    }

    public RocketLaunch(String name, LocalDateTime launchTime) {
        validateParameters(name, launchTime);

        this.name = name;
        this.launchTime = launchTime.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    private void validateParameters(String name, LocalDateTime launchTime) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Ракета без имени");
        }
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : launches) {
            executor.submit(() -> {
                long waitTime = rocketLaunch.getLaunchTime() - startTime;
                try {
                    if (waitTime > 0) {
                        Thread.sleep(waitTime);
                    }
                    rocketLaunch.launch();
                } catch (InterruptedException e) {
                    System.err.println("Операция была прервана ракетой " + this.name + ": " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        awaitTermination(executor);

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения планирования запусков: " + (endTime - startTime) + " мс");
    }

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Ракета " + this.name + " запускается");
        } catch (InterruptedException e) {
            System.err.println("Операция была прервана ракетой " + this.name + ": " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void awaitTermination(ExecutorService executor) {
        try {
            if (executor.awaitTermination(60, TimeUnit.MINUTES)) {
                System.out.println("Все запуски завершены.");
            } else {
                System.out.println("Некоторые запуски не завершились в указанный срок(час)");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Ошибка при ожидании завершения задач: " + e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
