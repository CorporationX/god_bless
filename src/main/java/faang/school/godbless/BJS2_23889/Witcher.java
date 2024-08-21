package faang.school.godbless.BJS2_23889;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;;

public class Witcher {
    private static final int NUM_THREAD = 2;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(10, 80), 10));
        monsters.add(new Monster("Cockatrice", new Location(120, 70), 6));
        monsters.add(new Monster("Chort", new Location(210, 60), 15));
        monsters.add(new Monster("Basilisk", new Location(50, 30), 8));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);
        long startTime = System.currentTimeMillis();
        cities.stream()
                .map(city -> new CityWorker(city, monsters))
                .forEach(executor::submit);
        executor.shutdown();
        awaitCompletion(executor);
        long endTime = System.currentTimeMillis();
        System.out.println("Working time: " + (endTime - startTime) + " ms");
    }

    private static void awaitCompletion(ExecutorService executor) {
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Execution service error");
        }
    }
}
