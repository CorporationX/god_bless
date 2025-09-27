package school.faang.sprint3.witcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static final int CITY_SIZE = 3;
    public static final int MONSTER_SIZE = 3;

    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Saint Petersburg", new Location(1D, 1D)),
                new City("Moscow", new Location(2D, - 3D)),
                new City("Pskov", new Location(- 3D, 1D))
        );

        List<Monster> monsters = List.of(
                new Monster("Stream", new Location(1D, 1D)),
                new Monster("Parallelism", new Location(2D, 2D)),
                new Monster("Concurrency", new Location(5D, 5D))
        );

        taskTimeCompletion(4, Executors.newFixedThreadPool(4), cities, monsters);
        taskTimeCompletion(10, Executors.newFixedThreadPool(10), cities, monsters);
        taskTimeCompletion(1, Executors.newSingleThreadExecutor(), cities, monsters);

    }

    public static void taskTimeCompletion(int threadCount, ExecutorService executorService, List<City> cities,
                                          List<Monster> monsters) {
        try {
            long start = System.currentTimeMillis();
            addTasks(executorService, cities, monsters);
            executorService.shutdown();
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.printf("With %s = %d\n", threadCount, System.currentTimeMillis() - start);
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка ожидания");
        }

    }

    public static void addTasks(ExecutorService executorService, List<City> cities, List<Monster> monsters) {
        if (cities.size() != CITY_SIZE && monsters.size() != MONSTER_SIZE) {
            throw new IllegalArgumentException("Incorrect size");
        }
        executorService.execute(new CityWorker(cities.get(0), List.of(monsters.get(0), monsters.get(1),
                monsters.get(2))));
        executorService.execute(new CityWorker(cities.get(1), List.of(monsters.get(0), monsters.get(1),
                monsters.get(2))));
        executorService.execute(new CityWorker(cities.get(2), List.of(monsters.get(0), monsters.get(1),
                monsters.get(2))));
        executorService.execute(new CityWorker(cities.get(0), List.of(monsters.get(1), monsters.get(2))));
        executorService.execute(new CityWorker(cities.get(1), List.of(monsters.get(0), monsters.get(1))));
        executorService.execute(new CityWorker(cities.get(2), List.of(monsters.get(2), monsters.get(1))));
        executorService.execute(new CityWorker(cities.get(0), List.of(monsters.get(2), monsters.get(0))));
    }
}
