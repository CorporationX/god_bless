package faang.school.godbless.bjs2_5437;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (String character : characterNames) {
            executorService.execute(new FoodDeliveryTask(character, new Random().nextInt(20) + 1));
        }
        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
