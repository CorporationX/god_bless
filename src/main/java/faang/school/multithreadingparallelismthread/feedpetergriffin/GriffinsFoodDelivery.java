package faang.school.multithreadingparallelismthread.feedpetergriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static final int COUNT_THREAD = 3;
    private static final int COUNT_RANDOM_FOOD_AMOUNT = 50;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            int count = new Random().nextInt(COUNT_RANDOM_FOOD_AMOUNT);

            executor.submit(new FoodDeliveryTask(name, count));
        }

        executor.shutdown();
    }
}
