package school.faang.peter_griffen;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        final Random rand = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName, rand.nextInt(1, 50)));
        }
        executorService.shutdown();
    }
}
