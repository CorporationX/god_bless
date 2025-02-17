package school.faang.putfingeronpath;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final List<City> CITIES = Arrays.asList(
            new City("Город1", new Location(10, 20)),
            new City("Город2", new Location(30, 40)),
            new City("Город3", new Location(-20, -15)),
            new City("Город4", new Location(50, 25)),
            new City("Город5", new Location(-35, 60))
    );
    private static final List<Monster> MONSTERS = Arrays.asList(
            new Monster("Монстр1", new Location(15, 25)),
            new Monster("Монстр2", new Location(35, 45)),
            new Monster("Монстр3", new Location(-25, -10)),
            new Monster("Монстр4", new Location(55, 30)),
            new Monster("Монстр5", new Location(-40, 65))
    );
    private static double TO_MILLISECONDS = 1_000_000.0;
    private static final int[] POOL_SIZES = {1, 2, 4, 8};

    public static void main(String[] args) {
        // многопоточный режим
        for (int poolSize : POOL_SIZES) {
            log.info("Начало многопоточного выполнения с пулом потоков: {}", poolSize);
            ExecutorService executor = Executors.newFixedThreadPool(poolSize);
            long startTime = System.nanoTime();
            for (City city : CITIES) {
                CityWorker worker = new CityWorker(city, MONSTERS);
                executor.execute(worker);
            }
            executor.shutdown();
            try {
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    log.warn("Не все задачи завершились за отведенное время");
                }
            } catch (InterruptedException e) {
                log.error("Ожидание завершения потоков прервано", e);
                Thread.currentThread().interrupt();
            }
            long endTime = System.nanoTime();
            long durationParallel = endTime - startTime;
            log.info("Время выполнения в многопоточном режиме с пулом {} потоков: {} мс",
                    poolSize, durationParallel / TO_MILLISECONDS);
        }

    }
}
