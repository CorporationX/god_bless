package faang.school.godbless.BJS2_5528;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i <= characterNames.length; i++){
            int number = i;
            executor.submit(() -> {
                synchronized (foodDeliveryTask) {
                    foodDeliveryTask.setCharacter(characterNames[number]);
                    foodDeliveryTask.run();
                }
            });
        }

        executor.shutdown();
    }
}
