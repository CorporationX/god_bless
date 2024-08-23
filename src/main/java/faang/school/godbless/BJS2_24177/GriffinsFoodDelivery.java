package faang.school.godbless.BJS2_24177;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService pollThread = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            int index = i;
            pollThread.submit(() -> {
                int randomNumber = new Random().nextInt(1, 50);
                FoodDeliveryTask newTask = new FoodDeliveryTask(characterNames[index], randomNumber);
                newTask.run();
            });
        }
    }
}
