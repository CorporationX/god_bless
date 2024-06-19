package faang.school.godbless.multithreading.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        for (String character: characterNames) {
            executorService.submit(new FoodDeliveryTask(character, new Random().nextInt(50)));
        }

        executorService.shutdown();

        System.out.println("Потоки завершены: " + executorService.isTerminated());
        Thread.sleep(30000);
        System.out.println("Потоки завершены: " + executorService.isTerminated());
    }
}
