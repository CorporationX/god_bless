package school.faang.BJS235974;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(50) + 1;
            executorService.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executorService.shutdown();
    }
}
