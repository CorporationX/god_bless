package faang.school.godbless.sprint4_multithreading.griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames).forEach(name -> executorService
                .submit(new FoodDeliveryTask(name, new Random().nextInt(50))));
        executorService.shutdown();
    }
}
