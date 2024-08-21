package faang.school.godbless.FeedPeterGriffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(10) + 1;
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executor.execute(task);
        }

        executor.shutdown();
    }
}
