package faang.school.godbless.BJS25686;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(101);
            Runnable task = new FoodDeliveryTask(character, foodAmount);
            executor.execute(task);
        }

        executor.shutdown();
    }
}
