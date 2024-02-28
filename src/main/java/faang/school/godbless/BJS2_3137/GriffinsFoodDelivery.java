package faang.school.godbless.BJS2_3137;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_NUMBER = 3;

    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        var randomGenerator = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
        Arrays.stream(characterNames).forEach((characterName) -> executorService.submit(new FoodDeliveryTask(characterName, randomGenerator.nextInt(20) + 1)));
        executorService.shutdown();
        boolean terminationResult = executorService.awaitTermination(60, TimeUnit.SECONDS);
        executorService.shutdownNow();
        if (terminationResult) {
            System.out.println("All deliveries done!");
        } else {
            System.out.println("Not all deliveries have been completed!");
        }
    }
}