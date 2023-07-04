package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Path_TheWitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(10, 10)));
        monsters.add(new Monster("Basilisk", new Location(100, 30)));
        monsters.add(new Monster("Cockatrice", new Location(10, 20)));
        monsters.add(new Monster("Chort", new Location(20, 30)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        final int NUM_THREADS = 4;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            executor.submit(new CityWorker(cities, city, monsters));
        }

        executor.shutdown();

        long end = System.currentTimeMillis();
        try {
            if (executor.awaitTermination(100, TimeUnit.SECONDS)) {
                System.out.println(end - start);
            } else {
                System.out.println("GG");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}