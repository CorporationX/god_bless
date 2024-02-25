package faang.school.godbless.pieter_grifin;

import java.util.Random;
import java.util.concurrent.*;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        final int THREAD = 3;
        ExecutorService executor = Executors.newFixedThreadPool(THREAD);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Random random = new Random();

        for (String characterName : characterNames) {
            int randomFoodAmount = random.nextInt(5) + 1;
            Runnable foodDeliveryTask = new FoodDeliveryTask(characterName, randomFoodAmount);
            executor.submit(foodDeliveryTask);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Not all task completed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
