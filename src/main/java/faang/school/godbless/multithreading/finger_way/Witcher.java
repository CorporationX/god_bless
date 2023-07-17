package faang.school.godbless.multithreading.finger_way;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        executeAndCheckTime(NUM_THREADS);
        System.out.println();
        executeAndCheckTime(1);
    }

    private static void executeAndCheckTime(int threadsCount) throws InterruptedException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        long start = System.currentTimeMillis();

        cities.forEach(city -> executorService.submit(new CityWorker(city, monsters)));
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }

    private static List<City> getCities() {
        return List.of(
                new City("Novigrad", new Location(0, 60),  180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}
