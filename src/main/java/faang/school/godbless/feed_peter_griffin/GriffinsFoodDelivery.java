package faang.school.godbless.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String name : characterNames) {
            int foodAmount = getFoodAmount();
            executor.execute(new FoodDeliveryTask(name, foodAmount));
        }

        executor.shutdown();
    }

    public static int getFoodAmount() {
        return new Random().nextInt(50) + 1;
    }
}
