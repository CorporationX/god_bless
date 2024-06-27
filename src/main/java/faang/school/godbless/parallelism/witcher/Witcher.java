package faang.school.godbless.parallelism.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUMBER_OF_THREADS = 1;
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        long start = System.currentTimeMillis();
        for(City city : cities){
            executor.submit(new CityWorker(city, monsters));
        }
        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start));
    }
}
