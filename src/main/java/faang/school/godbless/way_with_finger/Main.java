package faang.school.godbless.way_with_finger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(20, 60)));
        monsters.add(new Monster("Basilisk", new Location(0, 80)));
        monsters.add(new Monster("Cockatrice", new Location(100, 100)));
        monsters.add(new Monster("Chort", new Location(15, 10)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            executorService.submit(new CityWorker(monsters, city));
        }
        executorService.shutdown();
    }
}