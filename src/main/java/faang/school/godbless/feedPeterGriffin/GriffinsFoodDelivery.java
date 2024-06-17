package faang.school.godbless.feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String characterName : characterNames) {
            executorService.submit(new FoodDeliveryTask(characterName, new Random().nextInt(100)));
        }
        executorService.shutdown();
    }
}
