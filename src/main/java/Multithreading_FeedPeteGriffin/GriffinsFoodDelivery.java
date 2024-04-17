package Multithreading_FeedPeteGriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        Arrays.stream(characterNames)
                .toList()
                .forEach(characterName -> {
                    threadPool.execute(() -> {
                        FoodDeliveryTask character = new FoodDeliveryTask(characterName, random.nextInt(1, 100));
                        character.run();
                    });
                });

        threadPool.shutdown();
    }
}
