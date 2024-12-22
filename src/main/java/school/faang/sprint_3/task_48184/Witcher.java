package school.faang.sprint_3.task_48184;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class Witcher {
    private static final int AMOUNT_OF_CITIES = 10;
    private static final int AMOUNT_OF_MONSTERS = 10;

    private static final int MAX_X_BORDER = 1000;
    private static final int MAX_Y_BORDER = 1000;

    private static final int THREADS_POOL_SIZE_1 = 1;
    private static final int THREADS_POOL_SIZE_4 = 4;
    private static final int THREADS_POOL_SIZE_16 = 16;
    private static final int TERMINATION_DELAY = 5;

    public static void main(String[] args) {
        List<City> cities = generateEntities(AMOUNT_OF_CITIES, "City", City::new);
        List<Monster> monsters = generateEntities(AMOUNT_OF_MONSTERS, "Monster", Monster::new);

        long startOfExecution = System.currentTimeMillis();
        parallelExecution(cities, monsters, THREADS_POOL_SIZE_1);
        long endOfExecution = System.currentTimeMillis();
        System.out.printf("\n\nOne thread execution time: %d\n\n\n", (endOfExecution - startOfExecution));

        startOfExecution = System.currentTimeMillis();
        parallelExecution(cities, monsters, THREADS_POOL_SIZE_4);
        endOfExecution = System.currentTimeMillis();
        System.out.printf("\n\n%d thread execution time: %d\n\n\n",
                THREADS_POOL_SIZE_4,
                (endOfExecution - startOfExecution));

        startOfExecution = System.currentTimeMillis();
        parallelExecution(cities, monsters, THREADS_POOL_SIZE_16);
        endOfExecution = System.currentTimeMillis();
        System.out.printf("\n\n%d thread execution time: %d\n\n\n",
                THREADS_POOL_SIZE_16,
                (endOfExecution - startOfExecution));
    }

    private static void parallelExecution(List<City> cities, List<Monster> monsters, int threadPoolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_DELAY, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    private static <T> List<T> generateEntities(int amountOfEntities,
                                                String nameFoundation,
                                                BiFunction<String, Location, T> action) {
        List<T> entities = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= amountOfEntities; i++) {
            entities.add(action.apply(nameFoundation + " " + i,
                    new Location(random.nextInt(MAX_X_BORDER),
                            random.nextInt(MAX_Y_BORDER))));
        }
        return entities;
    }
}
