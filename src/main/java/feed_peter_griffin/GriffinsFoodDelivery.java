package feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (var character: characterNames) {
            FoodDeliveryTask delivery = new FoodDeliveryTask(character, generateRandomNumber());
            executor.submit(delivery);
        }
        executor.shutdown();
    }
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
}
