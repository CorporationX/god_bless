package faang.school.godbless.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String characterName : characterNames) {
            executor.submit(() -> new FoodDeliveryTask(characterName,
                    new Random().nextInt() * 100));
        }
        executor.shutdown();
    }
}
