package school.faang.task47756;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        String[] charactersNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random rand = new Random();

        Arrays.stream(charactersNames).forEach(name ->
                executorService.execute(new FoodDeliveryTask(name, rand.nextInt(50))));

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            System.out.println("All eats");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
