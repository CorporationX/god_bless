package Sprint_3.BJS2_36081;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(50)+1;
            FoodDeliveryTask task = new FoodDeliveryTask(characterName, foodAmount);
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
