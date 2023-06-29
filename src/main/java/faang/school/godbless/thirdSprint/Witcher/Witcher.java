package faang.school.godbless.thirdSprint.Witcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(6);
        long before = System.currentTimeMillis();

        List<Monster> monsters = List.of(
                new Monster("Griffin", "Velen", new Location(0, 50)),
                new Monster("Basilisk", "Toussaint", new Location(120, 50)),
                new Monster("Cockatrice", "White Orchard", new Location(20, 40)),
                new Monster("Chort", "Skellige", new Location(150, 0))
        );

        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30)
        );
        City currentCity = new City("Kaer Morhen", new Location(180, 70), 0);

        for (City city : cities) {
            service.submit(new CityWorker(currentCity, city, monsters));
            currentCity = city;
        }
        service.shutdown();

        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
