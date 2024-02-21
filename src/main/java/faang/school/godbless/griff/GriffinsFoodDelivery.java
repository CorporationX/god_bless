package faang.school.godbless.griff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        final int THREADS = 3;
        ExecutorService foodDeliveryTask = Executors.newFixedThreadPool( THREADS );
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Random amount = new Random();
        for (String character : characterNames) {
            foodDeliveryTask.submit( new FoodDeliveryTask( character, amount.nextInt( 15 ) ));
        }

        foodDeliveryTask.shutdown();

        try {
            if (!foodDeliveryTask.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Failed to complete all tasks within 1 minute");
                foodDeliveryTask.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting for task completion interrupted:" + e.getMessage());
        }
    }
}
