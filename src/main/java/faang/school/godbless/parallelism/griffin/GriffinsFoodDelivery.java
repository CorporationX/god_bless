package faang.school.godbless.parallelism.griffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.random.RandomGenerator;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            int foodAmount = RandomGenerator.getDefault().nextInt(1, 100);
            executor.submit(new FoodDeliveryTask(characterName, foodAmount));
        }
        executor.shutdown();
    }

}
