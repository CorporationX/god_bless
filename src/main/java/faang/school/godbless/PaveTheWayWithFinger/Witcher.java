package faang.school.godbless.PaveTheWayWithFinger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREAD_AMOUNT = 4;

    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        List<Monster> monsters = new ArrayList<>();
        Map<String, Location> locationMap = new HashMap<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        locationMap.put("Velen", new Location(10, 20));
        locationMap.put("Toussaint", new Location(30, 40));
        locationMap.put("White Orchard", new Location(50, 60));
        locationMap.put("Skellige", new Location(70, 80));

        monsters.add(new Monster("Griffin", locationMap.get("Velen")));
        monsters.add(new Monster("Basilisk", locationMap.get("Toussaint")));
        monsters.add(new Monster("Cockatrice", locationMap.get("White Orchard")));
        monsters.add(new Monster("Chort", locationMap.get("Skellige")));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.execute(cityWorker);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("Total time taken: " + totalTime + " milliseconds.");
        } catch (InterruptedException e) {
            System.err.println("Something went wrong at delivering process: " + e.getMessage());
            e.printStackTrace();
        }
    }
}