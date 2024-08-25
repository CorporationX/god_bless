package faang.school.godbless.BJS2_24020;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Arrays.stream(characterNames)
                .forEach(name -> executor.execute(new FoodDeliveryTask(name, random.nextInt(1, 50))));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5 * characterNames.length, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
