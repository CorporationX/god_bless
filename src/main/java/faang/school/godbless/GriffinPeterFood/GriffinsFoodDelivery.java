package faang.school.godbless.GriffinPeterFood;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Arrays.stream(characterNames)
                .forEach(i -> executorService
                        .submit(() -> new FoodDeliveryTask(i, new Random().nextInt(100))
                                .run()));
        executorService.shutdown();
    }
}
