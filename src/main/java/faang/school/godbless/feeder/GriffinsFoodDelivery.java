package faang.school.godbless.feeder;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            executorService.execute(new FoodDeliveryTask(characterNames[i], new Random().nextInt(50) + 1));
        }
        executorService.shutdown();
        executorService.awaitTermination(25, TimeUnit.SECONDS);
        System.out.println("Все покушали");
    }
}
