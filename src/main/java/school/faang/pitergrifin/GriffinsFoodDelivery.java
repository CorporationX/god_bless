package school.faang.pitergrifin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MAX_FOOD_COUNT = 50;
    private static final int MAX_TIME_WAIT = 100;

    private static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (String name : characterNames) {
            executor.submit(new FoodDeliveryTask(name, new Random().nextInt(1, MAX_FOOD_COUNT)));
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(MAX_TIME_WAIT, TimeUnit.SECONDS)) {
                System.out.println("Работа программы завершена");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}