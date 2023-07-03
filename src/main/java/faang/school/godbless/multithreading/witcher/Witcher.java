package faang.school.godbless.multithreading.witcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = List.of(
                new Monster("Griffin", new Location(0, 80)),
                new Monster("Basilisk", new Location(20, 0)),
                new Monster("Cockatrice", new Location(50, 60)),
                new Monster("Chort", new Location(120, 60))
        );
        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 138),
                new City("Vizima", new Location(120, 50), 63),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );

        runWithMultithreading(cities, monsters);
        runWithWithoutMultithreading(cities, monsters);
    }

    private static void runWithMultithreading(List<City> cities, List<Monster> monsters) {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(4);
        cities.forEach(city -> service.execute(new CityWorker(city, monsters)));
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("With multithreading: " + (end - start));
    }

    private static void runWithWithoutMultithreading(List<City> cities, List<Monster> monsters) {
        long start = System.currentTimeMillis();
        cities.forEach(city -> new CityWorker(city, monsters).run());
        long end = System.currentTimeMillis();
        System.out.println("Without multithreading: " + (end - start));
    }
}
