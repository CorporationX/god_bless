package faang.school.godbless.parallelism.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String charName : characterNames) {
            executorService.execute(new FoodDeliveryTask(charName, new Random().nextInt(50)));
        }

        executorService.shutdown();

        System.out.println("Конец основного потока");
    }
}
