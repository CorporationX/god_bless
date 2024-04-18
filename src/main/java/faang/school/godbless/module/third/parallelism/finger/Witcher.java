package faang.school.godbless.module.third.parallelism.finger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = List.of(
            new Monster("Griffin", new Location(0, 180)),
            new Monster("Basilisk", new Location(60, 200)),
            new Monster("Cockatrice", new Location(40, 20)),
            new Monster("Chort", new Location(80, 20))
        );
        List<City> cities = List.of(
            new City("Novigrad", new Location(0, 60)),
            new City("Oxenfurt", new Location(60, 0)),
            new City("City1", new Location(40, 0)),
            new City("City2", new Location(80, 20)),
            new City("City3", new Location(100, 40)),
            new City("City4", new Location(120, 60)),
            new City("City5", new Location(140, 80)),
            new City("City6", new Location(160, 100)),
            new City("City7", new Location(200, 120)),
            new City("City8", new Location(120, 250)),
            new City("Kaer Morhen", new Location(180, 70))
        );
        int NUM_THREADS = 5;
        long start = System.currentTimeMillis();
        
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5 * cities.size(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Затраченное время в секундах : " + TimeUnit.MILLISECONDS.toSeconds(end - start));
    }
}
