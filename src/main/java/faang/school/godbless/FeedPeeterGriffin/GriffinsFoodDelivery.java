package faang.school.godbless.FeedPeeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stevie"};

        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            int foodAmount = random.nextInt(50) + 1;
            executor.submit(new FoodDeliveryTask(character, foodAmount));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("All food received");
        } catch (InterruptedException e) {
            System.err.println("Something went wrong at delivering process: " + e.getMessage());
        }
    }
}
