package school.faang.BJS236321;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Москва", new Location(1, 1), 10, 20, 30, 40));
        cityList.add(new City("Санкт-Петербург", new Location(2, 2), 50, 60, 70, 80));
        cityList.add(new City("Казань", new Location(3, 3), 100, 110, 120, 130));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Дракон", new Location(4, 4), 200, 300));
        monsters.add(new Monster("Гоблин", new Location(5, 5), 400, 500));
        monsters.add(new Monster("Тролль", new Location(6, 6), 600, 700));

        Castle castle = new Castle(new Location(0, 9), 0, 0, 0, 0);
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (City city : cityList) {
            CityWorker cityWorker = new CityWorker(city, monsters, castle);
            executor.execute(cityWorker);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        long endTime = System.currentTimeMillis();
        System.out.println("Общее время выполнения программы: " + (endTime - startTime) + " мс");
        System.out.println();
        System.out.println("Время выполнения программы в однопоточном режиме: " + Executor.executeSingleThread(cityList, monsters, castle) + " мс");
        System.out.println();
        System.out.println("Время выполнения программы в многопоточном режиме с 3 потоками: " + (endTime - startTime) + " мс");
        System.out.println();
        System.out.println("Время выполнения программы в многопоточном режиме с 5 потоками: " + Executor.executeMultiThread(cityList, monsters, castle, 5) + " мс");
    }
}
