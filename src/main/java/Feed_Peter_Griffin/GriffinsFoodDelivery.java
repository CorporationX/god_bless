package Feed_Peter_Griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (int i = 0; i < characterNames.length; i++){
            String characterName = characterNames[i];
            int foodQuantity = new Random().nextInt(1,50);
            executorService.execute(new FoodDeliveryTask(characterName,foodQuantity));
        }
        executorService.shutdown();
    }
}
