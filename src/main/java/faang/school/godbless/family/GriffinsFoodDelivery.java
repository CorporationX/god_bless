package faang.school.godbless.family;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (String characterName : characterNames) {
            executor.submit(new FoodDeliveryTask(characterName, random.nextInt(10)));
        }
        executor.shutdown();
    }
}
