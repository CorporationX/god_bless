package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String... args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String character : characterNames) {
            executor.submit(new FoodDeliveryTask(character, new Random().nextInt(1, 50)));
        }
        executor.shutdown();
    }
}
