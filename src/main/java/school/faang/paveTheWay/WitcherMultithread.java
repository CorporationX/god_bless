package school.faang.paveTheWay;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WitcherMultithread {
    private static final int POOL_NUMBER = 4;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<City> cities = ListsInitializer.initializeCitiesList();
        List<Monster> monsters = ListsInitializer.initializeMonstersList();

        ExecutorService executor = Executors.newFixedThreadPool(POOL_NUMBER);
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executor.submit(worker);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                executor.shutdownNow();  // Принудительное завершение потоков
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Время выполнения программы: " + executionTime + " миллисекунд");
    }
}
