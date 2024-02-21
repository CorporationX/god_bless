package faang.school.godbless.priscillasong2904;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    static List<Monster> monsters = Monster.getMonsters();
    static List<City> cities = City.getCitiesList();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(4);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        long startTimeMultiThread = System.currentTimeMillis();
        test(multiThreadExecutor);
        long endTimeMultiThread = System.currentTimeMillis();
        multiThreadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.printf("Multi-threaded run needs %d to complete",
                startTimeMultiThread - endTimeMultiThread);

        long startTimeSingleThread = System.currentTimeMillis();
        test(singleThreadExecutor);
        long endTimeSingleThread = System.currentTimeMillis();
        singleThreadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.printf("Single-threaded run needs %d to complete",
                startTimeSingleThread - endTimeSingleThread);

    }

    public static void test(ExecutorService executor) {
        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }
        executor.shutdown();
    }
}
