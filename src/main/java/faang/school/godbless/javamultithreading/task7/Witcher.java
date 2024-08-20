package faang.school.godbless.javamultithreading.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 3;


    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}
