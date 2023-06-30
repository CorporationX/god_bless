package faang.school.godbless.multithreading.feed_peter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService deliveryService = Executors.newFixedThreadPool(5);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(10);
            deliveryService.submit(new FoodDeliveryTask(character, foodAmount));
        }
        deliveryService.shutdown();
    }
}
