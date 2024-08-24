package faang.school.godbless.FeedPeterGriffin;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class GriffinsFoodDelivery {
    private static ConcurrentHashMap<String, String> taskStatus = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(10) + 1;
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount, taskStatus);
            executor.execute(task);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        taskStatus.forEach((character, status) -> System.out.println(character + ": " + status));
    }
}
