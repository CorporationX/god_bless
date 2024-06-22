package faang.school.godbless.rask_2_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            int amountFood = new Random().nextInt(1, 20);
            executorService.submit(new FoodDeliveryTask(name, amountFood));
        }

        executorService.shutdown();
    }
}
