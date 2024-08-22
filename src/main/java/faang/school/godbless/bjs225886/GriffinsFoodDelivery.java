package faang.school.godbless.bjs225886;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (var character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, new Random().nextInt(5) + 1));
        }
        executorService.shutdown();
    }
}