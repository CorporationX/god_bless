package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    private static final Random GREAT_RANDOM = new Random();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (String characterName : CHARACTER_NAMES) {
            FoodDeliveryTask task = new FoodDeliveryTask(characterName, GREAT_RANDOM.nextInt(1, 100));
            executorService.submit(task);
        }
        executorService.shutdown();
    }
}
