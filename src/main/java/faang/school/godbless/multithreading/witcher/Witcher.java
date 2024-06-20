package faang.school.godbless.multithreading.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {

    public static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();

        City novigrad = new City("Novigrad", new Location(0, 60), 180);
        City oxenfurt = new City("Oxenfurt", new Location(60, 0), 70);
        City vizima = new City("Vizima", new Location(120, 50), 30);
        cities.add(novigrad);
        cities.add(oxenfurt);
        cities.add(vizima);

        List<Monster> monsters = new ArrayList<>();

        Monster griffin = new Monster("Griffin", novigrad);
        Monster vasilisk = new Monster("Vasilisk", novigrad);
        Monster cockatrice = new Monster("Cockatrice", oxenfurt);
        monsters.add(griffin);
        monsters.add(vasilisk);
        monsters.add(cockatrice);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executor.execute(cityWorker);
        }

        executor.shutdown();
    }
}
