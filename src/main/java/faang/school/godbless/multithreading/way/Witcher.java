package faang.school.godbless.multithreading.way;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {

    private static final int NUM_THREADS = 1;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen", 10));
        monsters.add(new Monster("Basilisk", "Toussaint", 30));
        monsters.add(new Monster("Cockatrice", "White Orchard", 20));
        monsters.add(new Monster("Chort", "Velen", 30));
        monsters.add(new Monster("Chort", "Velen", 20));
        monsters.add(new Monster("Chort", "White Orchard", 10));
        monsters.add(new Monster("Chort", "Velen", 20));
        monsters.add(new Monster("Chort", "White Orchard", 30));
        monsters.add(new Monster("Griffin", "Velen", 10));
        monsters.add(new Monster("Basilisk", "Toussaint", 30));
        monsters.add(new Monster("Griffin", "Skellege", 10));
        monsters.add(new Monster("Basilisk", "Skellege", 30));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Velen", new Location(90, 60)));
        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));
        cities.add(new City("White Orchard", new Location(190, 70)));
        cities.add(new City("Toussaint", new Location(0, 70)));
        cities.add(new City("Skellege", new Location(180, 180)));
        CityWorker.setNameCities(cities);
        CityWorker.setMonsters(monsters);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {}
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения программы с " + NUM_THREADS + " потоками: " + (endTime - startTime));
    }
}
