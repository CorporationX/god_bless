package school.faang.task_48235;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {

        List<City> cities = List.of(
                new City("Novigrad", new Location(10, 20)),
                new City("Oxenfurt", new Location(15, 25)),
                new City("Kaer Morhen", new Location(5, 10))
        );

        List<Monster> novigradMonsters = List.of(
                new Monster("Griffin", new Location(12, 22)),
                new Monster("Basilisk", new Location(14, 24))
        );

        List<Monster> oxenfurtMonsters = List.of(
                new Monster("Wraith", new Location(6, 11)),
                new Monster("Vampire", new Location(8, 15))
        );

        List<Monster> kaerMorhenMonsters = List.of(
                new Monster("Lesser Demon", new Location(2, 3)),
                new Monster("Ghost", new Location(1, 1))
        );

        List<CityWorker> cityWorkers = List.of(
                new CityWorker(cities.get(0), novigradMonsters),
                new CityWorker(cities.get(1), oxenfurtMonsters),
                new CityWorker(cities.get(2), kaerMorhenMonsters)
        );

        ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        long startTime = System.currentTimeMillis();
        for (CityWorker cityWorker : cityWorkers) {
            executorService.submit(cityWorker);
        }
        executorService.shutdown();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.printf("\nВремя выполнения: %d миллисекунд", executionTime);

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.info("Принудительное завершение при прерывании" + e.getMessage());
        }
    }
}
