package leadTheWayWithYourFinger_36590;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int COUNT_CITIES = 10;
    private static final int COUNT_MONSTERS = 50;

    public static void main(String[] args) {

        Random random = new Random();
        int maxCount = Math.max(COUNT_CITIES, COUNT_MONSTERS);
        List<Monster> monsters = new ArrayList<>();
        List<City> cities = new ArrayList<>();

        for (int i = 0; i < maxCount; i++) {
            if (i < COUNT_CITIES) {
                cities.add(new City("city" + i,
                        new Location(random.nextInt(1000), random.nextInt(1000)))
                );
            }
            if (i < COUNT_MONSTERS) {
                monsters.add(new Monster("monster" + i,
                        new Location(random.nextInt(1000), random.nextInt(1000)))
                );
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_CITIES);
        long start = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
            System.out.println("Программа завершает свою работу.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Время работы программы: " + (end - start) + " мс");
    }
}
