package faang.school.godbless.witcher;

import faang.school.godbless.witcher.models.City;
import faang.school.godbless.witcher.models.Location;
import faang.school.godbless.witcher.models.Monster;
import faang.school.godbless.witcher.services.CityWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final List<Monster> MONSTERS;
    private static final List<City> CITIES;

    private static final int NUMBER_OF_THREADS = 4;

    static {
        MONSTERS = new ArrayList<>(List.of(
                new Monster("Griffin", new Location(0, 50), 1L),
                new Monster("Basilisk", new Location(50, 0), 2L),
                new Monster("Cockatrice", new Location(100, 50), 3L),
                new Monster("Chort", new Location(50, 100), 1L)));

        CITIES = new ArrayList<>(List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)));
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        long startTime = System.currentTimeMillis();
        for (City city : CITIES) {
            executor.execute(new CityWorker(city, MONSTERS));
        }
        executor.shutdown();
        executor.awaitTermination(20L, TimeUnit.SECONDS);
        long finishTime = System.currentTimeMillis();

        System.out.println("Finished in " + (finishTime - startTime) + " ms");
    }
}
