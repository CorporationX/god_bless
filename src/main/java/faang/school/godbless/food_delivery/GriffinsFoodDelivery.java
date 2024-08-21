package faang.school.godbless.food_delivery;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (var character : characterNames) {
            threadPool.submit(new FoodDeliveryTask(character, new Random().nextInt(100)));
        }
        threadPool.shutdown();

    }
}
