package peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String name : characterNames) {
            int foodAmount = new Random().nextInt(101);
            FoodDeliveryTask task = new FoodDeliveryTask(name, foodAmount);
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}
