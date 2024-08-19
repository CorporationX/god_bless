package faang.school.godbless.BJS2_24090;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    static final int THREADS_COUNT = 3;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        for (String characterName : characterNames) {
            executor.submit(new FoodDeliveryTask(
                    characterName,
                    new Random().nextInt(100)));
        }
        executor.shutdown();
    }
}
