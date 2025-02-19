package school.faang.BJS2_61171;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            executor.submit(new FoodDeliveryTask(characterName, random.nextInt(1, 10)));
        }
        executor.shutdown();
    }
}
