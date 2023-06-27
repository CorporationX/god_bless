package faang.school.godbless.multithreadingS4.feedGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (var name : characterNames) {
            executorService.execute(new FoodDeliveryTask(name, random.nextInt(100) + 1));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("\nEveryone ate");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
