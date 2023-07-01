package faang.school.godbless.threads.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            executorService.execute(new FoodDeliveryTask(characterNames[i], new Random().nextInt(20) + 1));
        }
        executorService.shutdown();
    }
}
