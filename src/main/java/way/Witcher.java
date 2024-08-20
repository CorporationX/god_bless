package way;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = List.of(
                new Monster("Griffin", new Location(120, 40)),
                new Monster("Basilisk", new Location(60, 30)),
                new Monster("Cockatrice", new Location(200, 80)),
                new Monster("Chort", new Location(10, 80)));
        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            LocalDateTime start = LocalDateTime.now();
            cities.forEach(c -> executor.submit(new CityWorker(c, monsters)));
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                Duration duration = Duration.between(start, LocalDateTime.now());
                System.out.printf("The map do it's magic in %d moments%n", duration.getNano() / 1000000);
            } else {
                System.out.println("The map magic taking too long");
            }
        }
    }
}
