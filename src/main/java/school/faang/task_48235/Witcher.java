package school.faang.task_48235;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(10, 20)));
        cities.add(new City("Oxenfurt", new Location(15, 25)));
        cities.add(new City("Kaer Morhen", new Location(5, 10)));


        List<Monster> novigradMonsters = new ArrayList<>();
        novigradMonsters.add(new Monster("Griffin", new Location(12, 22)));
        novigradMonsters.add(new Monster("Basilisk", new Location(14, 24)));

        List<Monster> oxenfurtMonsters = new ArrayList<>();
        oxenfurtMonsters.add(new Monster("Wraith", new Location(6, 11)));
        oxenfurtMonsters.add(new Monster("Vampire", new Location(8, 15)));

        List<Monster> kaerMorhenMonsters = new ArrayList<>();
        kaerMorhenMonsters.add(new Monster("Lesser Demon", new Location(2, 3)));
        kaerMorhenMonsters.add(new Monster("Ghost", new Location(1, 1)));


        List<CityWorker> cityWorkers = new ArrayList<>();
        cityWorkers.add(new CityWorker(cities.get(0), novigradMonsters));
        cityWorkers.add(new CityWorker(cities.get(1), oxenfurtMonsters));
        cityWorkers.add(new CityWorker(cities.get(2), kaerMorhenMonsters));

        ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        long startTime = System.currentTimeMillis();
        for (CityWorker cityWorker : cityWorkers) {
            executorService.submit(cityWorker);
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.printf("Время выполнения: %d миллисекунд\n", executionTime);

    }

}
