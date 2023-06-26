package Lay_a_path;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new int[]{0, 60, 120, 180}));
        cities.add(new City("Oxenfurt", new int[]{60, 0, 50, 70}));
        cities.add(new City("Vizima", new int[]{120, 50, 0, 30}));
        cities.add(new City("Kaer Morhen", new int[]{180, 70, 30, 0}));

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Total execution time is " + totalTime + "millis");
    }
}
