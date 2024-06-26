package faang.school.godbless.BJS2_11916;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Замеры при разном количестве потоков, монстров и городов дали следующие результаты
_____________________________________________________________________________________________________________
            |4 монстра, 4 города     |6 монстров, 4 города    |4 монстра, 6 городов    |6 монстров, 6 городов
_____________________________________________________________________________________________________________
1 поток     |       7мс              |      8мс               |       10мс             |       8мс
_____________________________________________________________________________________________________________
3 потока    |       13мс             |      8мс               |       7мс              |       7мс
_____________________________________________________________________________________________________________
 */


public class Witcher {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) throws InterruptedException {


        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(10, 40)));
        monsters.add(new Monster("Basilisk", new Location(40, 130)));
        monsters.add(new Monster("Cockatrice", new Location(150, 90)));
        monsters.add(new Monster("Chort", new Location(220, 0)));
        monsters.add(new Monster("Diablo", new Location(170, 20)));
        monsters.add(new Monster("Rumpelstirlzhen", new Location(270, 220)));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 120),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 10), 0));
        cities.add(new City("Ansi", new Location(30, 140), 30));
        cities.add(new City("Dzhodhpur", new Location(250, 250), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        cities.forEach(city -> executorService.submit(new CityWorker(city, monsters)));

        executorService.shutdown();
        long endTime = System.currentTimeMillis();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Время выполнения: " + (endTime - startTime) + " ms");
        }
    }
}
