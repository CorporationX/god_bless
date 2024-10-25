package Sprint_3.BJS2_36445;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
        new City("Vizima", new Location(15, 25)),
        new City("Oxenfurt", new Location(10, 50)),
        new City("Novigrad", new Location(5, 40))
        );

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Dragon", new Location(10, 20)));
        monsters.add(new Monster("Griffin", new Location(15, 45)));
        monsters.add(new Monster("Vampire", new Location(20, 50)));

        ExecutorService executorService = Executors.newFixedThreadPool(cities.size());

        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }
        executorService.shutdown();

    }
}