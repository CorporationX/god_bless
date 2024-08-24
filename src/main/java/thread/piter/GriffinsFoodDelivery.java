package thread.piter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static Random rand = new Random();

    public static void main(String[] args) {
        int threadCount = 3;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            int foodCount = rand.nextInt(10) + 1;
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterNames[i], foodCount);
            executor.submit(() -> foodDeliveryTask.run());
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }

        System.out.println("Все накормлены.");

    }
}
