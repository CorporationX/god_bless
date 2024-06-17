package faang.school.godbless.multithreading.petergriffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            var foodQuantity = ThreadLocalRandom.current().nextInt(1, 12);
            executorService.submit(new FoodDeliveryTask(characterName, foodQuantity));
        }
        executorService.shutdown();
    }
}
