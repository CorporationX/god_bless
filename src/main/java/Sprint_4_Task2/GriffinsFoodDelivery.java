package Sprint_4_Task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Random random = new Random();
        for (int i = 0; i < characterNames.length; i++) {
            executorService.execute(new FoodDeliveryTask(characterNames[i], random.nextInt(50)+1));
        }
        executorService.shutdown();

    }
}
