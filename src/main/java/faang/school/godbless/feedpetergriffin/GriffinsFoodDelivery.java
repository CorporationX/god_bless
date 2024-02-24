package faang.school.godbless.feedpetergriffin;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String... args) throws IOException {
        final int numberOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        int orderQuantity = new Random().nextInt(30);
        int waitingTime = new Random().nextInt(5000);
        for (String character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, orderQuantity, waitingTime));
        }
        executorService.shutdown();
    }
}
