package multithreading.feedgriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (int i = 0; i < characterNames.length; i++) {
            executorService.submit(new FoodDeliveryTask(characterNames[i], random.nextInt(50)));
        }
        if (executorService.isTerminated()) {
            executorService.shutdown();
        }
    }
}
