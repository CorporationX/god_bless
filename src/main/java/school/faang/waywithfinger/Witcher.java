package school.faang.waywithfinger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREAD_COUNT_SIZE = 8;
    private static final int MAX_TIME_WORK = 8;
    private static final int NUMBER_OF_CITIES = 10;
    private static final int NUMBER_OF_MONSTERS = 100;
    private static final int CARD_SIZE = 100;

    public static void main(String[] args) {
        Random random = new Random();
        List<City> cities = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUMBER_OF_CITIES; i++) {
            cities.add(new City("City" + i, new Location(random.nextInt(CARD_SIZE), random.nextInt(CARD_SIZE))));
        }

        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_MONSTERS; i++ ) {
            monsters.add(new Monster("Monster" + i,
                    new Location(random.nextInt(CARD_SIZE), random.nextInt(CARD_SIZE))));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT_SIZE);

        for (City city : cities) {
            executor.submit(() -> new CityWorker(city, monsters).run());
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS)) {
                System.out.println("Программа завершена");
            } else {
                System.out.println("Программа завершена принудительно");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Программа выполнялась " + (System.currentTimeMillis() - startTime) + " мс");
    }
}