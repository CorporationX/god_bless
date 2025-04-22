package school.faang.witcher;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        long start;
        final List<City> cities = WitcherWorldGenerator.generateCities(10);
        final List<Monster> monsters = WitcherWorldGenerator.generateMonsters(40);
        final ExecutorService oneThreadExecutor = Executors.newSingleThreadExecutor();
        final ExecutorService twoThreadExecutor = Executors.newFixedThreadPool(2);
        final ExecutorService fiveThreadExecutor = Executors.newFixedThreadPool(5);

        start = System.currentTimeMillis();

        cities.forEach(city -> oneThreadExecutor.submit(new CityWorker(city, monsters)));
        shutdownExecutor(oneThreadExecutor);
        log.info("With 1 thread finished in {} ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();

        cities.forEach(city -> twoThreadExecutor.submit(new CityWorker(city, monsters)));
        shutdownExecutor(twoThreadExecutor);
        log.info("With 2 thread finished in {} ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();

        cities.forEach(city -> fiveThreadExecutor.submit(new CityWorker(city, monsters)));
        shutdownExecutor(fiveThreadExecutor);
        log.info("With 5 thread finished in {} ms", System.currentTimeMillis() - start);
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Executor shutdown with timeout");
            executor.shutdownNow();
        }
    }
}
