package faang.school.godbless.multithreading_parallelism.task_7;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int NUM_THREADS = 1;
    private static final int TERMINATION_TIME = 3;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        cities.forEach(city -> executor.submit(new CityWorker(city, monsters)));
        executor.shutdown();
        try {
            executor.awaitTermination(TERMINATION_TIME, TimeUnit.SECONDS);
            System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}
