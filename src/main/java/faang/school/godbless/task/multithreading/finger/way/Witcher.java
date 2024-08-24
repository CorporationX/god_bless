package faang.school.godbless.task.multithreading.finger.way;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final int GERALD_X = 180;
    private static final int GERALD_Y = 70;
    private static final int NUM_THREADS = 2;
    private static final int CALCULATE_TIME_LIMIT = 2;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    private static Location geraldLocation;
    private static List<Monster> monsters;
    private static List<City> cities;
    private static long start;

    public static void main(String[] args) {
        initialDefaults();
        log.info("\nНачало выполнения программы");
        start = System.currentTimeMillis();
        cities.forEach(city -> executorService.submit(new CityWorker(city, monsters, geraldLocation)));
        executorService.shutdown();
        printCalculationTime();
    }

    private static void printCalculationTime() {
        try {
            if (executorService.awaitTermination(CALCULATE_TIME_LIMIT, TimeUnit.MINUTES)) {
                long end = System.currentTimeMillis();
                log.info("\nВремя выполнения расчетов %s миллисекунд".formatted(end - start));
            } else {
                log.warn("\nВремя расчетов вышло за ограничение в %s минут".formatted(CALCULATE_TIME_LIMIT));
            }
        } catch (InterruptedException exception) {
            log.error("Ошибка во время выполнения {}: ", exception.getMessage());
        }
    }

    private static void initialDefaults() {
        geraldLocation = new Location(GERALD_X, GERALD_Y);
        monsters = getMonsters();
        cities = getCities();
    }

    private static List<City> getCities() {
        return List.of(
                new City("Novigrad", new Location(0, 60)),
                new City("Oxenfurt", new Location(60, 0)),
                new City("Vizima", new Location(120, 50)),
                new City("Kaer Morhen", new Location(180, 70))
        );
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", new Location(100, 30), 400),
                new Monster("Basilisk", new Location(40, 20), 500),
                new Monster("Cockatrice", new Location(30, -30), 300),
                new Monster("Chort", new Location(130, -30), 100)
        );
    }
}
