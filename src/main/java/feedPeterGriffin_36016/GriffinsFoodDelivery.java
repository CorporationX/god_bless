package feedPeterGriffin_36016;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Random random = new Random();

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stevie"};
        for (String character : characterNames) {
            executor.execute(new FoodDeliveryTask(character, random.nextInt(1, 50)));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ёще не всем доставлена еда");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
