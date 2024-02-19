package faang.school.godbless.multithreading_parallelism.peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(String character: characterNames){
            int foodAmount = new Random().nextInt(50);
            FoodDeliveryTask deliveryFood = new FoodDeliveryTask(character, foodAmount);
            executor.submit(deliveryFood);
        }
        executor.shutdown();
    }
}
