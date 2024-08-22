package faang.school.godbless.FeedPeter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie", "Brian"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            executorService.execute(new FoodDeliveryTask(characterNames[i], new Random().nextInt(10)));
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Something went wrong");
                executorService.shutdownNow();
            } else {
                System.out.println("Everyone is fed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
