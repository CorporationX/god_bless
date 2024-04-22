package faang.school.godbless.Task_19;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
            String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
            for (int i = 0; i < 3; i++) {
                executorService.submit(new FoodDeliveryTask(characterNames[new Random().nextInt(characterNames.length)], new Random().nextInt(0, 1000)));
            }
        executorService.shutdown();
    }
}
