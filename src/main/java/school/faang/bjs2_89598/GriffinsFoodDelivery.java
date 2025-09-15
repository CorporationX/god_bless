package school.faang.bjs2_89598;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (String character : characterNames) {
            int foodAmount = random.nextInt(3, 7);
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executor.shutdown();
    }
}
