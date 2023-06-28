package faang.school.godbless.task.feedPeter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < 1000; i++) {
            executor.submit(new FoodDeliveryTask(characterNames[new Random().nextInt(characterNames.length)], new Random().nextInt(1, 10)));
        }
    }
}
