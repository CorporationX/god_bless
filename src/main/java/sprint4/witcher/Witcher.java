package sprint4.witcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final List<Monster> MONSTERS = List.of(
            new Monster("Griffin", "Velen"),
            new Monster("Basilisk", "Toussaint"),
            new Monster("Cockatrice", "White Orchard"),
            new Monster("Chort", "Skellige")
    );
    private static final List<City> CITIES = List.of(
            new City("Novigrad", new Location(0, 60),  180),
            new City("Oxenfurt", new Location(60, 0), 70),
            new City("Vizima", new Location(120, 50), 30),
            new City("Kaer Morhen", new Location(180, 70), 0)
    );
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : CITIES) {
            service.execute(new CityWorker(city, MONSTERS));
        }
        service.shutdown();

        try {
            service.awaitTermination(2, TimeUnit.SECONDS);
            service.shutdownNow();
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }

        long finishTime = System.currentTimeMillis();
        System.out.printf("Total time: %d ms", finishTime - startTime);
    }
}
