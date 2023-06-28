package faang.school.godbless.feedPiterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            int foodAmount = new Random().nextInt(1, 100);
            executorService.submit(new FoodDeliveryTask(characterNames[i], foodAmount));
        }

        executorService.shutdown();
    }
}
