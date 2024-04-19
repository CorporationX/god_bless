package faang.school.godbless.BJS2_5746;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
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

        ExecutorService poolService = Executors.newFixedThreadPool(5);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            poolService.submit(new CityWorker(city, monsters));
        }

        poolService.shutdown();

        try {
            if (!poolService.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                poolService.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolService.shutdownNow();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}
