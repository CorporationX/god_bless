package school.faang.BJS236321;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    public static long executeSingleThread(List<City> cityList, List<Monster> monsters, Castle castle) {
        long startTime = System.currentTimeMillis();
        for (City city : cityList) {
            CityWorker cityWorker = new CityWorker(city, monsters, castle);
            cityWorker.run();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long executeMultiThread(List<City> cityList, List<Monster> monsters, Castle castle, int numThreads) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (City city : cityList) {
            CityWorker cityWorker = new CityWorker(city, monsters, castle);
            executor.execute(cityWorker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // ждем завершения всех потоков
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
