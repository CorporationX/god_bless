package faang.school.godbless.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (int i = 0; i < characterNames.length; i++) {
            executorService.submit(new FoodDeliveryTask(characterNames[i], random.nextInt(100)));
        }
        executorService.shutdown();
    }
}
