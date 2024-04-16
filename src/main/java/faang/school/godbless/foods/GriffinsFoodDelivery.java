package faang.school.godbless.foods;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            executor.submit(
                    new FoodDeliveryTask(characterName, new Random().nextInt(80))
            );
        }
        executor.shutdown();
    }
}

