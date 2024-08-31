package piterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService execute = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterNames[i], 50);
            execute.execute(foodDeliveryTask);
        }
        execute.shutdown();
        try {
            if (!execute.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                execute.shutdownNow();
            }
        } catch (InterruptedException e) {
            execute.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
