package faang.school.godbless.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int AMOUNT_OF_THREAD = 3;
    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService deliveryService = Executors.newFixedThreadPool(AMOUNT_OF_THREAD);

        for (String character : CHARACTER_NAMES) {
            int foodAmount = new Random().nextInt(5) + 1;
            deliveryService.submit(new FoodDeliveryTask(character, foodAmount));
        }
        deliveryService.shutdown();
    }
}
