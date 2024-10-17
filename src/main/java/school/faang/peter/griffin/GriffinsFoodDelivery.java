package school.faang.peter.griffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GriffinsFoodDelivery {
    private static final int NUMBER_OF_THREADS_IN_POOL = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS_IN_POOL);
        String[] characters = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String character : characters) {
            executor.submit(new FoodDeliveryTask(character,
                    ThreadLocalRandom.current().nextInt(1, 50)));
        }
        executor.shutdown();
    }
}
