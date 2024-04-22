package faang.school.godbless.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Bob", "Anna", "Bill", "Lola", "Mike"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < characterNames.length; i++) {
            int foodAmount = new Random().nextInt(100) + 1;
            executorService.execute(new FoodDeliveryTask(characterNames[i], foodAmount));
        }
        executorService.shutdown();
    }
}
