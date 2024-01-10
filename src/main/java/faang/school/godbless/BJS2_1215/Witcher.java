package faang.school.godbless.BJS2_1215;

import faang.school.godbless.BJS2_1115.Main;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final City witcherCity = new City("Kaer Morhen", new Location(180, 70));
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();
        for (City city : cities) {
            executorService.submit(new CityWorker(city, witcherCity, monsters));
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }

    private static List<City> getCities() {
        return List.of(
                new City("Kaer Morhen", new Location(180, 70)),
                new City("Novigrad", new Location(0, 60)),
                new City("Oxenfurt", new Location(60, 0)),
                new City("Vizima", new Location(-30, -130))
        );
    }
}