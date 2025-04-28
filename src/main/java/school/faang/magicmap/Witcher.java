package school.faang.magicmap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
public class Witcher {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(10.0, 60.0)));
        cities.add(new City("Oxenfurt", new Location(15.0, 65.0)));
        cities.add(new City("Kaer Morhen", new Location(50.0, 70.0)));
        cities.add(new City("Beauclair", new Location(20.0, 40.0)));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(15.0, 55.0)));
        monsters.add(new Monster("Wyvern", new Location(25.0, 45.0)));
        monsters.add(new Monster("Leshen", new Location(12.0, 62.0)));
        monsters.add(new Monster("Vampire", new Location(30.0, 35.0)));

        testSingleThread(cities, monsters);
        testMultiThread(cities, monsters);
    }

    @SneakyThrows
    private static void testSingleThread(List<City> cities, List<Monster> monsters) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final long startTime = System.currentTimeMillis();

        cities.forEach(city -> new CityWorker(city, monsters).run());

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
        log.info("Single threaded execution time is {} ms", System.currentTimeMillis() - startTime);
    }

    @SneakyThrows
    private static void testMultiThread(List<City> cities, List<Monster> monsters) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        final long startTime = System.currentTimeMillis();

        cities.stream().map(city -> new CityWorker(city, monsters)).forEach(executor::execute);

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
        log.info("{} threaded execution time is {} ms", THREAD_COUNT, System.currentTimeMillis() - startTime);
    }
}