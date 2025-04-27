package school.faang.feed_peter_griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Random random = new Random();
        Arrays.stream(characterNames)
                .forEach(characterName -> {
                    int foodAmount = random.nextInt(50) + 1;
                    FoodDeliveryTask task = new FoodDeliveryTask(characterName, foodAmount);
                    executor.submit(task);
                });
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Не все доставки завершились за 1 минуту!");
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