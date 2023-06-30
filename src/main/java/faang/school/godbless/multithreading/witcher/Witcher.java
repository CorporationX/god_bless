package faang.school.godbless.multithreading.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(0, 80)));
        monsters.add(new Monster("Basilisk", new Location(20, 0)));
        monsters.add(new Monster("Cockatrice", new Location(50, 60)));
        monsters.add(new Monster("Chort", new Location(120, 60)));
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 138));
        cities.add(new City("Vizima", new Location(120, 50), 63));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        long start;
        long end;

        start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(4);
        cities.forEach(city -> service.execute(new CityWorker(city, monsters)));
        service.shutdown();
        if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
            service.shutdownNow();
        }
        end = System.currentTimeMillis();
        System.out.println("With multithreading: " + (end - start));

        start = System.currentTimeMillis();
        cities.forEach(city -> new CityWorker(city, monsters).run());
        end = System.currentTimeMillis();
        System.out.println("With out multithreading: " + (end - start));
    }
}
