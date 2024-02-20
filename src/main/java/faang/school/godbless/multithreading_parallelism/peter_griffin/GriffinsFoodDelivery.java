package faang.school.godbless.multithreading_parallelism.peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int COUNT_THREAD = 4;
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);
        for(String character: characterNames){
            int foodAmount = random.nextInt(50);
            FoodDeliveryTask deliveryFood = new FoodDeliveryTask(character, foodAmount);
            executor.submit(deliveryFood);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Все покушали");
    }
}
