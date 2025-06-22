package school.faang.magicmap;

import lombok.extern.slf4j.Slf4j;
import school.faang.magicmap.domain.City;
import school.faang.magicmap.domain.Location;
import school.faang.magicmap.domain.Monster;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "Witcher")
public class Witcher {

    public static final int THREADS_NUM = Runtime.getRuntime().availableProcessors();
    public static final int MAX_EXECUTOR_AWAIT_TERMINATION_TIME = 2;

    public static void main(String[] args) {
        var cities = List.of(
                new City("Perm", new Location(99, 150)),
                new City("Moscow", new Location(251, 642)),
                new City("Kazan", new Location(210, 312)),
                new City("Sochi", new Location(927, 131))
        );
        var monsters = List.of(
                new Monster("Monster 1", new Location(41, 52)),
                new Monster("Monster 2", new Location(729, 154)),
                new Monster("Monster 3", new Location(341, 617)),
                new Monster("Monster 4", new Location(519, 99)),
                new Monster("Monster 5", new Location(254, 219)),
                new Monster("Monster 6", new Location(140, 530))
        );
        benchmark(() -> {
            log.info("1 поток");
            for (var city : cities) {
                new CityWorker(city, monsters).run();
            }
        });
        log.info("");
        benchmark(() -> runWithThreadsNumEqualsToAvailableProcessors(cities, monsters));
        log.info("");
        benchmark(() -> runWithThreadsNumLessThanAvailableProcessors(cities, monsters));
        log.info("");
        benchmark(() -> runWithThreadsNumMoreThanAvailableProcessors(cities, monsters));
    }

    private static void benchmark(Runnable action) {
        long start = System.currentTimeMillis();
        action.run();
        long end = System.currentTimeMillis();
        log.info("Общее время выполнения: {}ms", (end - start));
    }

    private static void runWithThreadsNumEqualsToAvailableProcessors(List<City> cities, List<Monster> monsters) {
        runWithThreadCount(THREADS_NUM, cities, monsters);
    }

    private static void runWithThreadsNumLessThanAvailableProcessors(List<City> cities, List<Monster> monsters) {
        runWithThreadCount(Math.max(1, THREADS_NUM / MAX_EXECUTOR_AWAIT_TERMINATION_TIME), cities, monsters);
    }

    private static void runWithThreadsNumMoreThanAvailableProcessors(List<City> cities, List<Monster> monsters) {
        runWithThreadCount(THREADS_NUM * MAX_EXECUTOR_AWAIT_TERMINATION_TIME, cities, monsters);
    }

    private static void runWithThreadCount(int threadCount, List<City> cities, List<Monster> monsters) {
        log.info("Количество потоков: {}", threadCount);
        var executor = Executors.newFixedThreadPool(threadCount);
        for (var city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }
        shutDownExecutor(executor);
    }

    private static void shutDownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
