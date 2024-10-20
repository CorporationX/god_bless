package school.faang.godbless.bjs2_36331;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Witcher {
    private static final int MIN_COORDINATE = 1;
    private static final int MAX_COORDINATE = 10000;
    private static final Random RANDOM = new Random();
    private static final int MONSTERS_NUMBER = 50000;
    private static final int CITIES_NUMBER = 1000;

    public static void main(String[] args) {
        List<Monster> monsters = generateMonsters(MONSTERS_NUMBER);
        List<City> cities = generateCities(CITIES_NUMBER);
        StringBuilder executionTimeData = new StringBuilder("\n");
        IntStream.rangeClosed(1, 20).forEach(i -> {
            long time = runMultithreaded(monsters, cities, i);
            executionTimeData.append(i);
            executionTimeData.append(" threads. Execution time: ");
            executionTimeData.append(time);
            executionTimeData.append("\n");
        });
        long time = runInMainThread(monsters, cities);
        executionTimeData.append("Main thread only. Execution time: ");
        executionTimeData.append(time);
        log.info(executionTimeData.toString());
    }

    private static long runMultithreaded(List<Monster> monsters, List<City> cities, int threadsNumber) {
        if (threadsNumber < 1) {
            throw new IllegalStateException("Number of threads must greater then 0");
        }
        long timeStart = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(threadsNumber);
        cities.forEach(city -> pool.submit(new CityWorker(city, monsters)));
        pool.shutdown();
        try {
            if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                return System.currentTimeMillis() - timeStart;
            } else {
                throw new IllegalStateException("The pool is not terminated");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted while waiting pool termination");
        }
    }

    private static long runInMainThread(List<Monster> monsters, List<City> cities) {
        long timeStart = System.currentTimeMillis();
        cities.forEach(city -> new CityWorker(city, monsters).run());
        return System.currentTimeMillis() - timeStart;
    }

    private static List<City> generateCities(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> new City("City", new Location(
                        RANDOM.nextInt(MIN_COORDINATE, MAX_COORDINATE + 1),
                        RANDOM.nextInt(MIN_COORDINATE, MAX_COORDINATE + 1))
                )).toList();
    }

    private static List<Monster> generateMonsters(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> new Monster("Monster", new Location(
                        RANDOM.nextInt(MIN_COORDINATE, MAX_COORDINATE + 1),
                        RANDOM.nextInt(MIN_COORDINATE, MAX_COORDINATE + 1))
                )).toList();
    }
}
