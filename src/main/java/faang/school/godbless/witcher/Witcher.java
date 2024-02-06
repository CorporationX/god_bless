package faang.school.godbless.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {

    private static final int NUM_THREADS = 4;


    public static void main(String[] args) {

        Location location1 = new Location(10, 50);
        Location location2 = new Location(5, 40);
        Location location3 = new Location(25, 30);
        Location location4 = new Location(45, 15);

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", location1));
        monsters.add(new Monster("Basilisk", location2));
        monsters.add(new Monster("Cockatrice", location3));
        monsters.add(new Monster("Chort", location4));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();

        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения программы: " + (endTime - startTime) + "мс");
    }
}
