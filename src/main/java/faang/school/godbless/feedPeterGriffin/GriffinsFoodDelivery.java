package faang.school.godbless.feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static final int NUMBER_OF_THREADS = 3;
    public static Random random = new Random();
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (String character : characterNames) {
            int foodAmount = random.nextInt(51);
            FoodDeliveryTask deliveryTask = new FoodDeliveryTask(character, foodAmount);
            executorService.submit(deliveryTask);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(9, TimeUnit.SECONDS)) {
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            executorService.shutdown();
            Thread.currentThread().interrupt();
        }
        System.out.println("Griffin's heroes is fed");

    }
}