package BJS2_23892_PathByFinger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }
        executor.shutdown();
    }

    public static List<Monster> getMonsters() {
        return List.of(new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "White Orchard"),
                new Monster("Cockatrice", "Toussaint"),
                new Monster("Chort", "Skellige"));
    }

    public static List<City> getCities() {
        return List.of(new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }
}
