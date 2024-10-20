package school.faang.laypathwithyourfinger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                new City("Novigrad", new Location(10, 20)),
                new City("Oxenfurt", new Location(30, 40)),
                new City("Vizima", new Location(50, 10)),
                new City("Toussaint", new Location(20, 30))
        );

        List<Monster> monsters = Arrays.asList(
                new Monster("Griffin", new Location(12, 22)),
                new Monster("Drowner", new Location(31, 41)),
                new Monster("Leshen", new Location(52, 12)),
                new Monster("Wraith", new Location(22, 33))
        );

        long singleThreadStartTime = System.currentTimeMillis();
        cities.forEach(city -> new CityWorker(city, monsters).run());
        long singleThreadEndTime = System.currentTimeMillis();
        System.out.println("Single-thread execution time: " + (singleThreadEndTime - singleThreadStartTime) + "ms");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        long multiThreadStartTime = System.currentTimeMillis();
        cities.forEach(city -> executor.submit(new CityWorker(city, monsters)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long multiThreadEndTime = System.currentTimeMillis();
        System.out.println("Multi-thread execution time: " + (multiThreadEndTime - multiThreadStartTime) + "ms");
    }
}

