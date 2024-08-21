package faang.school.godbless.javamultithreading.task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(new FoodDeliveryTask(characterNames[random.nextInt(characterNames.length)],
                    random.nextInt(10)));
        }
        executor.shutdown();
    }
}
