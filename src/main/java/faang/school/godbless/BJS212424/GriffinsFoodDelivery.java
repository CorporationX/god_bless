package faang.school.godbless.BJS212424;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie", "Bryan"};

        Random random = new Random();
        for (String name : characterNames) {
            int foodAmount = 1 + random.nextInt(50);
            FoodDeliveryTask task = new FoodDeliveryTask(name, foodAmount);
            executorService.execute(task);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                List<Runnable> unfinishedTasks = executorService.shutdownNow();
                unfinishedTasks.forEach(System.out::println);
            } else {
                System.out.println("Every Griffin ate successfully");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
            throw new RuntimeException("Thread was interrupted: " + e.getMessage());
        }

    }
}
