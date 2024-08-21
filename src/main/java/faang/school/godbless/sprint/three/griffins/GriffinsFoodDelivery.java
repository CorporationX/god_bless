package faang.school.godbless.sprint.three.griffins;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GriffinsFoodDelivery {
    public static void main(String... args) {
        ExecutorService executor = Executors.newFixedThreadPool(Constants.THREADS_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames)
                .forEach(character -> {
                    executor.submit(new FoodDeliveryTask(character, getRandomFoodAmount()));
                });

        executor.shutdown();
    }

    public static int getRandomFoodAmount() {
        final int maxFoodAmount = 7;
        final int minFoodAmount = 1;
        return ThreadLocalRandom.current().nextInt(minFoodAmount, maxFoodAmount + 1);
    }
}
