package faang.school.godbless.BJS2_23927;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static final int THREADS_AMOUNT = 3;
    public static final int MAX_FOOD_AMOUNT = 50;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character: characterNames) {
            int foodAmount = new Random().nextInt(MAX_FOOD_AMOUNT);
            executorService.submit(() -> new FoodDeliveryTask(character, foodAmount).run());
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
