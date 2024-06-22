package faang.school.godbless.sprint3.deliverFoodToGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        Integer amountOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(amountOfThreads);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Integer maxAmountOfFood = 50;

        for (int i = 1; i <= amountOfThreads; i++) {
            executorService.submit(new FoodDeliveryTask(characterNames[i], new Random().nextInt(maxAmountOfFood)));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Thread pool haven't closed for 30 seconds");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
