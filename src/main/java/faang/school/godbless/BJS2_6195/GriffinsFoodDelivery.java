package faang.school.godbless.BJS2_6195;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            executorService.execute(new FoodDeliveryTask(characterNames[i], new Random().nextInt(1, 20)));
        }

        executorService.shutdown();
    }
}
