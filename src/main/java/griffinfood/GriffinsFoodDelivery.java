package griffinfood;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL = Runtime.getRuntime().availableProcessors();
    private static final int DELIVERY_FOOD_AMOUNT_LIMIT = 50;
    private static final int AWAIT_TERMINATION_TIME = 60;

    private static final String[] CHARACTERS = {
            "Peter", "Lois", "Meg", "Chris", "Stewie",
            "Brian", "Joe", "Neil", "Adam"
    };

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        for (var character : CHARACTERS) {
            FoodDeliveryTask task = new FoodDeliveryTask(random.nextInt(DELIVERY_FOOD_AMOUNT_LIMIT), character);
            executorService.submit(task);
        }

        executorService.shutdown();

        if (!executorService.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}