package faang.school.godbless.eat_Piter_Griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames)
                .forEach(string -> {
                    FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(string,
                            new Random().nextInt(50));

                    executor.submit(foodDeliveryTask);
                });
        executor.shutdown();
    }
}
