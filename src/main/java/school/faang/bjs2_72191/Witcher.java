package school.faang.bjs2_72191;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                new City("Novigrad", new Location(10, 20)),
                new City("Oxenfurt", new Location(15, 25)),
                new City("Vizima", new Location(30, 10)),
                new City("Kaer Morhen", new Location(-20, -15))
        );

        List<Monster> monsters = Arrays.asList(
                new Monster("Griffin", new Location(12, 18)),
                new Monster("Drowner", new Location(14, 26)),
                new Monster("Leshen", new Location(32, 12)),
                new Monster("Wyvern", new Location(-18, -12))
        );

        testSingleThread(cities, monsters);
        testMultiThread(cities, monsters, 2);
        testMultiThread(cities, monsters, 4);
    }

    private static void testSingleThread(List<City> cities, List<Monster> monsters) {
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            new CityWorker(city, monsters).run();
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("Single-threaded execution time: %d ms%n%n", duration);
    }

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    private static void testMultiThread(List<City> cities, List<Monster> monsters, int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        // Куда мне передвинуть startTime ниже? если я укажу её под for loop, то время будет не точное
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("%d-threaded execution time: %d ms%n%n", threadCount, duration);
    }
}
