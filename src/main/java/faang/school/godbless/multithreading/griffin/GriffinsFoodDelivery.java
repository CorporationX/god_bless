package faang.school.godbless.multithreading.griffin;

import java.util.Random;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            executorService.submit(new FoodDeliveryTask(characterName, new Random().nextInt(1, 50)));
        }
        executorService.shutdown();
    }
}
