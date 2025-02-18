package griffinfood;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] characters = {
                "Peter", "Lois", "Meg", "Chris", "Stewie",
                "Brian", "Joe", "Neil", "Adam"
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (var character : characters) {
            FoodDeliveryTask task = new FoodDeliveryTask(random.nextInt(50), character);
            executorService.submit(task);
        }

        executorService.shutdown();

        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}