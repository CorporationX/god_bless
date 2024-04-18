package BJS2_5711;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }

        executor.shutdown();
        try {
            while (!executor.awaitTermination(3, TimeUnit.SECONDS)) ;
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) / 1000 + "s");
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        return cities;
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", Location.getLocationCoordinates("Velen")));
        monsters.add(new Monster("Basilisk", Location.getLocationCoordinates("Toussaint")));
        monsters.add(new Monster("Cockatrice", Location.getLocationCoordinates("White Orchard")));
        monsters.add(new Monster("Chort", Location.getLocationCoordinates("Skellige")));
        return monsters;
    }

}
