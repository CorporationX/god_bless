package school.faang.griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames).forEach(c -> {
            int foodAmount = random.nextInt(100) + 1;
            service.submit(new FoodDeliveryTask(c, foodAmount));
        });

        service.shutdown();
        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("\nБеда настигла нежданно");
            service.shutdownNow();
        }
    }
}
