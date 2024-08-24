package thread.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        int threadCount = 4;
        List<City> cities = new ArrayList<>();
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.execute(cityWorker);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время на выполнение программы: " + (endTime - startTime) + " ms");
    }
}
