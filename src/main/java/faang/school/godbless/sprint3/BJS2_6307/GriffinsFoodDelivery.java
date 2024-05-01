package faang.school.godbless.sprint3.BJS2_6307;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

        Random randomizer = new Random();

        for (String name : characterNames) {
            FoodDeliveryTask task = new FoodDeliveryTask(name, randomizer.nextInt(100) + 1);
            executor.execute(task);
        }

        executor.shutdown();
    }
}
