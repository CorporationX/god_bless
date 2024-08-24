package faang.school.godbless.task25885;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (String name : characterNames) {
            int foodAmount = new Random().nextInt(20) + 3;
            executorService.execute(() -> new FoodDeliveryTask(name, foodAmount).run());
        }
        executorService.shutdown();
    }
}
