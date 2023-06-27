package faang.school.godbless.multithreading.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            executor.submit(new FoodDeliveryTask(
                    characterNames[random.nextInt(characterNames.length)],
                    random.nextInt(1, 100)
            ));
        }

        executor.shutdown();
    }
}
