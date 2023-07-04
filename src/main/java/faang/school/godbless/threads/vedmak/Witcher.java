package faang.school.godbless.threads.vedmak;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        int NUM_THREADS = 5;
        List<City> cities = getCities();
        List<Monster> monsters = getMonsters();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");
    }

    public static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        return monsters;
    }

    public static List<City> getCities() {
        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        return cities;
    }
}
