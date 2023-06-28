package faang.school.godbless.griffin;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            executor.submit(new FoodDeliveryTask(characterNames[i], new Random().nextInt(50)));
        }
        executor.shutdown();
    }

}
