package faang.school.godbless.multithreading;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int RANDOM_FOOD_AMOUNT = new Random().nextInt(50) + 1;
    public static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Arrays.stream(characterNames)
                .forEach(characterName -> executorService
                        .execute(new FoodDeliveryTask(characterName, RANDOM_FOOD_AMOUNT)));
        executorService.shutdown();
    }
}
