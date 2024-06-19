package faang.school.godbless.BJS2_12098;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            executorService.submit(new FoodDeliveryTask(characterName, new Random().nextInt(1, 100)));
        }
        executorService.shutdown();
    }
}
