package faang.school.godbless.feedpitergriffen;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        var randomAmountOfFood = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        var characterNames = List.of("Peter", "Lois", "Meg", "Chris", "Stewie");
        characterNames.forEach(name -> {
            executor.submit(new FoodDeliveryTask(name, randomAmountOfFood.nextInt(1, 50)));
        });
        executor.shutdown();
    }
}
