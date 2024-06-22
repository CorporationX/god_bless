package faang.school.godbless.BJS2_12159;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(() -> new FoodDeliveryTask(characterNames[finalI],
                    new Random().nextInt(1, 100)).run());
        }
        executorService.shutdown();
    }
}
