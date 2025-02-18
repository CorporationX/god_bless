package school.faang.feedpeter;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        Arrays.stream(characterNames)
                .map(character -> new FoodDeliveryTask(character, random.nextInt(1, 50)))
                .forEach(executor::submit);
        executor.shutdown();
    }
}
