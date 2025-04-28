package school.faang.feed_peter_griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static final int NUMBER_OF_DELIVERY_THREADS = 3;
    private static final int MAX_FOOD_AMOUNT = 50;
    private static final int MIN_FOOD_AMOUNT = 1;
    private static final int AWAIT_TERMINATION_TIMEOUT_MINUTES = 1;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_DELIVERY_THREADS);
        Random random = new Random();
        Arrays.stream(characterNames)
                .forEach(characterName -> {
                    int foodAmount = random.nextInt(MAX_FOOD_AMOUNT) + MIN_FOOD_AMOUNT;
                    FoodDeliveryTask task = new FoodDeliveryTask(characterName, foodAmount);
                    executor.submit(task);
                });
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                System.err.println("Не все доставки завершились за " + AWAIT_TERMINATION_TIMEOUT_MINUTES + " минуту!");
                executor.shutdownNow();
            } else {
                System.out.println("Все доставки успешно завершены!");
            }
        } catch (InterruptedException e) {
            System.err.println("Прерывание при ожидании завершения доставок.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}