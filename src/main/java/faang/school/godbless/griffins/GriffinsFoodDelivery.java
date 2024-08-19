package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (String characterName : CHARACTER_NAMES) {
            FoodDeliveryTask task = new FoodDeliveryTask(characterName, new Random().nextInt(1, 100));
            executorService.submit(task);
        }
        executorService.close();
    }
}
