package faang.school.godbless.Witcher;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witch {
    private static final int NUM_THREADS = 4;

    @SneakyThrows
    public static void main(String[] args) {
        List<Monster> monsters = Arrays.asList(
                new Monster("Griffin", new Location(112, 21), 10),
                new Monster("Basilisk", new Location(10, 0), 30),
                new Monster("Cockatrice", new Location(100, 100), 100),
                new Monster("Banan", new Location(3, 4), 900)
        );
        List<City> cities = Arrays.asList(
                new City("Novigrad", new Location(0, 60)),
                new City("Oxenfurt", new Location(60, 0)),
                new City("Vizima", new Location(120, 50)),
                new City("Kaer Morhen", new Location(180, 250))
        );
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        cities.forEach(city -> executor.submit(new CityWorker(city, monsters)));
        executor.shutdown();
        executor.awaitTermination(6, TimeUnit.SECONDS);
        System.out.println("Done");
    }
}
