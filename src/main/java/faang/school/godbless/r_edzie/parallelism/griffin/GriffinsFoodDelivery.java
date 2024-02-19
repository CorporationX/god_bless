package faang.school.godbless.r_edzie.parallelism.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executor.submit(new FoodDeliveryTask(characterName, new Random().nextInt(0, 100)));
        }

        executor.shutdown();
    }
}
