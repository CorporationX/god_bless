package faang.school.godbless.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new City("Velen", new Location(30, 0), 20), 1000));
        monsters.add(new Monster("Basilisk", new City("Toussaint", new Location(40, 50), 20), 2000));
        monsters.add(new Monster("Cockatrice", new City("White Orchard", new Location(110, 80), 50), 1500));
        monsters.add(new Monster("Chort", new City("Skellige", new Location(20, 40), 10), 500));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(80, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("The witcher cleaned all cities in " + (endTime - startTime) + " ms");
    }
}
