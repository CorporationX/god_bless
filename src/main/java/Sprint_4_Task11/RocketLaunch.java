package Sprint_4_Task11;

import lombok.Data;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class RocketLaunch implements Runnable {
    private String rocketName;
    private LocalDateTime time;
    private List<RocketLaunch> rocketLaunches;

    public RocketLaunch(String rocketName, LocalDateTime time) {
        this.rocketName = rocketName;
        this.time = time;
    }

    @SneakyThrows
    public void launch() {
        Thread.sleep(1000);
        System.out.println("Финиш");

    }


    @SneakyThrows
    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        long startTime = System.currentTimeMillis();
        System.out.println("Время начала выполнения: " + startTime);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : rocketLaunches) {
            executorService.submit(rocketLaunch);
        }
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Время выполнения: " + endTime);
    }

    @SneakyThrows
    @Override
    public void run() {
        Duration duration = Duration.between(LocalDateTime.now(), time);
        Thread.sleep(duration.getSeconds() * 1000);
        System.out.println("Старт");
        Thread.sleep(1000);
        System.out.println(rocketName + ": " + time);
        launch();
    }

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunchList = List.of(
                new RocketLaunch("Меркурий", LocalDateTime.now().plusSeconds(1)),
                new RocketLaunch("Венера", LocalDateTime.now().plusSeconds(3)),
                new RocketLaunch("Земля", LocalDateTime.now().plusSeconds(5))
        );
        planRocketLaunches(rocketLaunchList);

    }
}
