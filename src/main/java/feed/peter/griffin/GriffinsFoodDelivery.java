package feed.peter.griffin;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GriffinsFoodDelivery {
    private static final int THREADS_COUNT = 3;
    private static final List<String> PERSONAGES = List.of("Peter", "Lois", "Meg", "Chris", "Stewie");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (String personage : PERSONAGES) {
            int randomFoodAmount = ThreadLocalRandom.current().nextInt(2, 51);
            executorService.submit(new FoodDeliveryTask(personage, randomFoodAmount));
        }
        executorService.shutdown();
    }
}
