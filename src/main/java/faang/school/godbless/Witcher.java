package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(0, 80)));
        monsters.add(new Monster("Basilisk", new Location(200, 50)));
        monsters.add(new Monster("Cockatrice", new Location(120, 30)));
        monsters.add(new Monster("Chort", new Location(180, 180)));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        int NUM_THREADS = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.nanoTime();
        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        long totalTimeMillis = TimeUnit.MILLISECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
        System.out.println("Total execution time: " + totalTimeMillis + " milliseconds");
    }
}
