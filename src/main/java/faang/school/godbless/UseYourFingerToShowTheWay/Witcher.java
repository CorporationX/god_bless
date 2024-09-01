package faang.school.godbless.UseYourFingerToShowTheWay;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );

        List<City> cities = List.of(
                new City("Novigrad", Map.of(
                        "Velen", 60,
                        "Toussaint", 120,
                        "White Orchard", 180,
                        "Skellige", 240
                )),
                new City("Oxenfurt", Map.of(
                        "Velen", 30,
                        "Toussaint", 90,
                        "White Orchard", 150,
                        "Skellige", 210
                )),
                new City("Vizima", Map.of(
                        "Velen", 10,
                        "Toussaint", 60,
                        "White Orchard", 110,
                        "Skellige", 170
                )),
                new City("Kaer Morhen", Map.of(
                        "Velen", 80,
                        "Toussaint", 140,
                        "White Orchard", 200,
                        "Skellige", 260
                ))
        );

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + " milliseconds.");
    }
}
