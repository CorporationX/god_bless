package school.faang.bjs2_91046;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(characterNames.length);

        for (String c : characterNames) {
            int foodAmount = random.nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(c, foodAmount));
        }
        executor.shutdownNow();
    }
}
