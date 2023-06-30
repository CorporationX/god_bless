package faang.school.godbless.Sprint4.SpaceX;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RocketLaunch implements Runnable{
    private String nameLaunch;
    private LocalDateTime timeLaunch;
    @Override
    public void run() {
        try {
            launch();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void launch() throws InterruptedException {
        System.out.println("Запуск ракеты " + nameLaunch);
        Thread.sleep(1000);
        System.out.println(nameLaunch+" в пути ");

    }

    public static void planRocketLaunches(List<RocketLaunch> launches) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        launches.stream()
                .sorted((a, b) -> a.timeLaunch.compareTo(b.timeLaunch))
                .collect(Collectors.toList());

        for (RocketLaunch launch : launches) {
            Thread.sleep(launch.timeLaunch.getSecond()-LocalDateTime.now().getSecond());
            executor.execute(launch);
        }
        executor.shutdown();
        executor.awaitTermination(30000, TimeUnit.SECONDS);
    }
}
