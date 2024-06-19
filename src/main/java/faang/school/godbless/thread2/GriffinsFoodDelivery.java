package faang.school.godbless.thread2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static final int MAX_FOOD_AMOUNT = 20;
    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : characterNames) {
            executor.submit(new FoodDeliveryTask(name, new Random().nextInt(MAX_FOOD_AMOUNT)));
        }
        executor.shutdown();
    }
}
