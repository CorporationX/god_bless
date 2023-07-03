package faang.school.godbless.witcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 1;


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();

        getCities().stream()
            .map(city -> new CityWorker(city, getMonsters()))
            .forEach(executor::execute);

        executor.shutdown();

        try {
            await(executor, startTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        getCurrentTime(startTime);
    }

    private static void getCurrentTime(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
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

    private static void await(ExecutorService executor, long startTime) throws InterruptedException {
        boolean terminated = executor.awaitTermination(1000, TimeUnit.NANOSECONDS);
        if (terminated) {
            getCurrentTime(startTime);
        } else {
            System.out.println("Tasks didn't terminate");
        }
    }
}
