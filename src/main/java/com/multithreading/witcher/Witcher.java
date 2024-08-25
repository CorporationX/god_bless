package com.multithreading.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        Map<String, Location> locations = Map.of("Velen", new Location(20, 10),
                "Toussaint", new Location(60, 10),
                "White Orchard", new Location(125, 20),
                "Skellige", new Location(70, 180));

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));


        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        try {
            for (City city : cities) {
                service.execute(new CityWorker(city, monsters, locations));
            }
            service.shutdown();
            service.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}
