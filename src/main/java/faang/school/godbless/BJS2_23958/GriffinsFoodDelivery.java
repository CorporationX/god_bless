package faang.school.godbless.BJS2_23958;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private final static int THREAD_COUNT = 3;
    private final static int MAX_FOOD = 100;
    private final static int MIN_FOOD = 50;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(
                    characterName,
                    new Random().nextInt(MAX_FOOD - MIN_FOOD + 1) + MIN_FOOD)
            );
        }
        executorService.shutdown();
    }
}
