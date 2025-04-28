package school.faang.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(10, 100);
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executor.submit(task);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Принудительная остановка.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
