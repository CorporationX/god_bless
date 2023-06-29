package faang.school.godbless.sprint3.road;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        Map<String, Integer> distances1 = new HashMap<>();
        distances1.put("Oxenfurt", 10);
        distances1.put("Vizima", 20);
        cities.add(new City("Novigrad", 0, distances1));

        Map<String, Integer> distances2 = new HashMap<>();
        distances2.put("Novigrad", 10);
        distances2.put("Vizima", 5);
        cities.add(new City("Oxenfurt", 30, distances2));

        Map<String, Integer> distances3 = new HashMap<>();
        distances3.put("Novigrad", 20);
        distances3.put("Oxenfurt", 5);
        cities.add(new City("Vizima", 40, distances3));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", 10));
        monsters.add(new Monster("Basilisk", 25));
        monsters.add(new Monster("Cockatrice", 35));


        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }

        executor.shutdown();

    }
}
