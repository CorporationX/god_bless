package faang.school.godbless.griffin.food;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Arrays.stream(characterNames).forEach(name -> {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(name, new Random().nextInt(49) + 1);
            executorService.submit(foodDeliveryTask);
        });

        executorService.shutdown();
    }
}
