package griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            int j = i;
            executor.submit(() -> {
               FoodDeliveryTask character = new FoodDeliveryTask(characterNames[j], new Random().nextInt(1,100));
               character.run();
            });
        }

        executor.close();

    }

}
