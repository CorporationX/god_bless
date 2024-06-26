package faang.school.godbless.Sprint_3.BJS2_12176;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            int foodAmount = new Random().nextInt(100) + 1;
            FoodDeliveryTask task = new FoodDeliveryTask(name, foodAmount);
            executor.execute(task);
        }

        executor.shutdown();
    }
}
