import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> list = List.of(new RocketLaunch("Первый запуск", LocalDateTime.now().plusSeconds(5)), new RocketLaunch("Второй запуск", LocalDateTime.now().plusSeconds(10)), new RocketLaunch("Второй запуск", LocalDateTime.now().plusSeconds(15)));
        planRocketLaunches(list);
    }

    public static void planRocketLaunches(List<RocketLaunch> list) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : list) {
            executor.submit(rocketLaunch);
        }

        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.SECONDS);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
    }
}
