package faang.school.godbless.paveTheWayWithYourFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int numThreads = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

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

//        for(City city : cities){
//            CityWorker cityWorker = new CityWorker(city, monsters);
//            cityWorker.run();
//        }

        for(City city : cities){
            CityWorker cityWorker = new CityWorker(city, monsters);
            executor.submit(cityWorker);
        }
        executor.shutdown();


    }
}
