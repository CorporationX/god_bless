package Sprint_4_Task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad",10,new HashMap<>()));
        cities.add(new City("Oxenfurt",20,new HashMap<>()));
        cities.add(new City("Vizima",30,new HashMap<>()));
        cities.add(new City("Kaer Morhen",40,new HashMap<>()));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.shutdown();
    }
}
