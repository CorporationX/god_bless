package school.faang.module1.bjs2_81586;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {

    private static final Random random = new Random();
    private static final int POOL_SIZE = 5;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("city1", new Location(random.nextInt(100), random.nextInt(100))),
                new City("city2", new Location(random.nextInt(100), random.nextInt(100))),
                new City("city3", new Location(random.nextInt(100), random.nextInt(100))),
                new City("city4", new Location(random.nextInt(100), random.nextInt(100))),
                new City("city5", new Location(random.nextInt(100), random.nextInt(100))),
                new City("city6", new Location(random.nextInt(100), random.nextInt(100))),
                new City("city7", new Location(random.nextInt(100), random.nextInt(100)))
        );
        List<Monster> monsters = List.of(
                new Monster("monster1", new Location(random.nextInt(100), random.nextInt(100))),
                new Monster("monster2", new Location(random.nextInt(100), random.nextInt(100))),
                new Monster("monster3", new Location(random.nextInt(100), random.nextInt(100))),
                new Monster("monster4", new Location(random.nextInt(100), random.nextInt(100))),
                new Monster("monster5", new Location(random.nextInt(100), random.nextInt(100))),
                new Monster("monster6", new Location(random.nextInt(100), random.nextInt(100))),
                new Monster("monster7", new Location(random.nextInt(100), random.nextInt(100)))
        );
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        long start = System.currentTimeMillis();
        cities.forEach(city -> executorService.execute(new CityWorker(city, monsters)));
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи завершились за указанное время");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Задачи не завершились вовремя");
            executorService.shutdownNow();
        }
        long end = System.currentTimeMillis();
        log.info("Время выполнения: {} мс", (end - start));
    }
}