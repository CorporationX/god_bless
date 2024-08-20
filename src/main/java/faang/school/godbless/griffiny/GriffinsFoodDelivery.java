package faang.school.godbless.griffiny;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static final int THREAD_COUNT = 3;

    public static final int MAX_PRODUCT_VALUE = 50;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int foodCount = new Random().nextInt(MAX_PRODUCT_VALUE);

        for (String characterName : characterNames) {
            executor.execute(new FoodDeliveryTask(characterName, foodCount));
        }

        executor.shutdown();
    }
}
