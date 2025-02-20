package school.faang;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(character, foodAmount));
        }
        executor.shutdown();
    }
}
