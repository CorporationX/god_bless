package school.faang.sprint1.task_47787;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {


    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (int i = 0; i < characterNames.length; i++) {
            int foodAmount = random.nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(characterNames[i], foodAmount));
        }
        executor.shutdown();
    }
}
