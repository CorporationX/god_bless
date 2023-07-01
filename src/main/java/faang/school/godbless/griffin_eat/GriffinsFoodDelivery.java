package faang.school.godbless.griffin_eat;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (int i = 0; i < 3; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterNames[new Random().nextInt(characterNames.length)], new Random().nextInt(1, 6));
            executor.submit(() -> foodDeliveryTask.run());
        }
        executor.shutdown();
    }
}
