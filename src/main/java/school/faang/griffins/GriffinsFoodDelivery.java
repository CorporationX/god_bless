package school.faang.griffins;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        int randomNumForExecute = new Random().nextInt(1,25);

        for (String name : characterNames) {
            executorService.execute(new FoodDeliveryTask(name, randomNumForExecute));
        }
        executorService.shutdown();
    }
}
