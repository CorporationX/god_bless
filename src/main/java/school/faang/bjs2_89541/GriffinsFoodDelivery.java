package school.faang.bjs2_89541;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(
                    characterNames[random.nextInt(characterNames.length)],
                    random.nextInt(100));
            executor.execute(foodDeliveryTask);
        }
        executor.shutdown();
    }
}
