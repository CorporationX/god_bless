package faang.school.godbless.grifinsFamily;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        int nameСounter = 0;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(
                    characterNames[0 + nameСounter], new Random().nextInt(10));
            nameСounter++;

            executor.execute(foodDeliveryTask);
        }
        executor.shutdown();
    }
}

