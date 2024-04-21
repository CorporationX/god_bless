package TheWitcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int COUNT_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = getMonsters();

        List<City> cities = getCities();

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

        long start = System.currentTimeMillis();
        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения - " + (end - start) + " мс");
    }
    //с 4 потоками +/- 137 мс
    //с 1 потоком +/- 45 мс

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
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}
