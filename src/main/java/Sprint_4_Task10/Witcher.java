package Sprint_4_Task10;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    @SneakyThrows
    public static void main(String[] args) {
        int NUM_THREADS = 3;

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad",new Location(10, 20)));
        cities.add(new City("Oxenfurt",new Location(10, 20)));
        cities.add(new City("Vizima",new Location(10, 20)));
        cities.add(new City("Kaer Morhen",new Location(10, 20)));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }

        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}
