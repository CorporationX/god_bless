package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String... args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName: characterNames) {
            int foodAmount = new Random().nextInt(100) + 1;
            executorService.submit(new FoodDeliveryTask(characterName, foodAmount));
        }

        executorService.shutdown();
    }
}
