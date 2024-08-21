package faang.school.godbless.BJS2_23916;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {

    private static final int NUM_THREADS = 5;
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));



        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }
        executor.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
